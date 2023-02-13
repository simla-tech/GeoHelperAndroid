package com.simla.geohelper

import com.squareup.moshi.Moshi
import com.simla.geohelper.adapter.BaseResponseAdapter
import com.simla.geohelper.adapter.GeoHelperMapAdapter
import com.simla.geohelper.api.GeoHelperApi
import com.simla.geohelper.data.GeoHelperInterceptor
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GeoHelper(private val config: GeoHelperConfig) {

    @Suppress("MemberVisibilityCanBePrivate")
    val api: GeoHelperApi = getRetrofit().create(GeoHelperApi::class.java)

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(GeoHelperApi.BASE_URL)
            .client(getOkHttpClient())
            .addConverterFactory(getConverterFactory())
            .build()
    }

    private fun getConverterFactory(): Converter.Factory {
        val moshi = Moshi.Builder()
            .add(GeoHelperMapAdapter.Factory())
            .add(BaseResponseAdapter.Factory())
            .build()
        return MoshiConverterFactory
            .create(moshi)
    }

    private fun getOkHttpClient(): OkHttpClient {
        val interceptor = with(config) {
            GeoHelperInterceptor(apiKey, defaultLocale)
        }
        return config.okHttpClient?.let {
            it.newBuilder()
                .apply {
                    interceptors().add(0, interceptor)
                }
                .build()
        } ?: OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }
}
