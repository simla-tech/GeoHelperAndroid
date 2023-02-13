package com.simla.geohelper.adapter

import com.squareup.moshi.*
import java.lang.reflect.Type

class GeoHelperMapAdapter(
    private val delegate: JsonAdapter<Map<String, String>>
) : JsonAdapter<Map<String, String>>() {

    override fun fromJson(reader: JsonReader): Map<String, String>? {
        val peeked = reader.peekJson()
        val result = try {
            delegate.fromJson(peeked)
        } catch (e: JsonDataException) {
            emptyMap()
        } finally {
            peeked.close()
        }
        reader.skipValue()
        return result
    }

    override fun toJson(writer: JsonWriter, value: Map<String, String>?) {
        throw UnsupportedOperationException()
    }

    class Factory : JsonAdapter.Factory {

        override fun create(type: Type, annotations: Set<Annotation>, moshi: Moshi): JsonAdapter<*>? {
            val rawType: Class<*> = type.rawType
            return if (Map::class.java.isAssignableFrom(rawType)) {
                val delegate: JsonAdapter<Map<String, String>>? =
                    moshi.nextAdapter(this, type, annotations)
                delegate?.let { GeoHelperMapAdapter(it) }
            } else {
                null
            }
        }
    }
}