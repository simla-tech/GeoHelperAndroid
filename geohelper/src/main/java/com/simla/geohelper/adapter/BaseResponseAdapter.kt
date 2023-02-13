package com.simla.geohelper.adapter

import com.squareup.moshi.*
import com.simla.geohelper.data.GeoHelperException
import com.simla.geohelper.model.response.BaseResponse
import java.lang.reflect.Type

class BaseResponseAdapter<T : BaseResponse>(
    private val delegate: JsonAdapter<T>
) : JsonAdapter<T>() {

    override fun fromJson(reader: JsonReader): T? {
        val baseResponse = delegate.fromJson(reader)
        return baseResponse?.success?.let { isSuccessful ->
            if (!isSuccessful) {
                throw GeoHelperException.ApiError(baseResponse.error!!)
            }
            baseResponse
        }
    }

    override fun toJson(writer: JsonWriter, value: T?) {
        throw UnsupportedOperationException()
    }

    class Factory : JsonAdapter.Factory {

        override fun create(type: Type, annotations: Set<Annotation>, moshi: Moshi): JsonAdapter<*>? {
            val rawType: Class<*> = type.rawType
            return if (BaseResponse::class.java.isAssignableFrom(rawType)) {
                val delegate: JsonAdapter<out BaseResponse>? =
                    moshi.nextAdapter(this, type, annotations)
                delegate?.let { BaseResponseAdapter(it) }
            } else {
                null
            }
        }
    }
}