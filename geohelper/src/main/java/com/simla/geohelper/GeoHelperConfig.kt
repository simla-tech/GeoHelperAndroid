package com.simla.geohelper

import com.simla.geohelper.model.params.LocaleParam
import okhttp3.OkHttpClient

class GeoHelperConfig private constructor(
    val apiKey: String,
    val defaultLocale: LocaleParam,
    val okHttpClient: OkHttpClient?
) {

    class Builder(
        private val apiKey: String
    ) {
        private var defaultLocale: LocaleParam = LocaleParam.DEFAULT
        private var okHttpClient: OkHttpClient? = null

        fun defaultLocale(locale: LocaleParam) = apply { this.defaultLocale = locale }
        fun httpClient(client: OkHttpClient) = apply { this.okHttpClient = client }

        fun build() = GeoHelperConfig(
            apiKey,
            defaultLocale,
            okHttpClient
        )
    }
}