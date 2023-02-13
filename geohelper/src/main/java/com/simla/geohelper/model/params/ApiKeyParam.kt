package com.simla.geohelper.model.params

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ApiKeyParam(
    val apiKey: String
) : HashMap<String, String>(), Parcelable {

    private constructor() : this("")

    init {
        if (apiKey.isNotBlank()) {
            put(QUERY_PARAM_API_KEY, apiKey)
        }
    }

    companion object {
        const val QUERY_PARAM_API_KEY = "apiKey"

        val EMPTY = ApiKeyParam()
    }
}

