package com.simla.geohelper.data

import com.simla.geohelper.api.GeoHelperApi
import com.simla.geohelper.model.params.ApiKeyParam
import com.simla.geohelper.model.params.LocaleParam
import com.simla.geohelper.model.response.result.ErrorResult
import okhttp3.Interceptor
import okhttp3.Response
import okio.IOException
import org.json.JSONObject

class GeoHelperInterceptor(
    private val apiKey: String,
    private val defaultLocale: LocaleParam
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url
        val isGeoHelperRequest = url.toString().startsWith(GeoHelperApi.BASE_URL)
        val request = if (isGeoHelperRequest) {
            // add query params
            val updatedUrl = url.newBuilder()
                .apply {
                    if (!url.queryParameterNames.contains(ApiKeyParam.QUERY_PARAM_API_KEY)) {
                        addQueryParameter(ApiKeyParam.QUERY_PARAM_API_KEY, apiKey)
                    }
                    if (!url.queryParameterNames.contains(LocaleParam.QUERY_PARAM_LANG)) {
                        addQueryParameter(LocaleParam.QUERY_PARAM_LANG, defaultLocale.lang)
                    }
                    if (!url.queryParameterNames.contains(LocaleParam.QUERY_PARAM_FALLBACK_LANG)) {
                        defaultLocale.fallbackLang?.let { addQueryParameter(LocaleParam.QUERY_PARAM_FALLBACK_LANG, it) }
                    }
                }
                .build()
            chain.request()
                .newBuilder()
                .url(updatedUrl)
                .build()
        } else {
            // do nothing
            chain.request()
        }
        val response = chain.proceed(request)
        return if (isGeoHelperRequest && !response.isSuccessful) {
            when (response.code) {
                400, 403 -> {
                    // api error
                    val responseJson = response.body?.string()
                    responseJson?.parseErrorResult()?.let {
                        if (response.code == 400) {
                            throw GeoHelperException.BadRequest(it)
                        } else {
                            throw GeoHelperException.InvalidApiKey(it)
                        }
                    } ?: throw GeoHelperException.HttpError(response.code)
                }
                else -> {
                    // http request is unsuccessful
                    throw GeoHelperException.HttpError(response.code)
                }
            }
        } else {
            response
        }
    }

    private fun String.parseErrorResult(): ErrorResult {
        return try {
            val jsonObject = JSONObject(this)
            val errorObject = jsonObject.optJSONObject(ErrorResult.JSON_OBJECT_NAME)!!
            ErrorResult(
                errorObject.optInt(ErrorResult::code.name),
                errorObject.getString(ErrorResult::message.name),
                errorObject.optJSONArray(ErrorResult::details.name)
                    ?.let { 0.until(it.length()).map { i -> it.optString(i) } }
                    ?: emptyList()
            )
        } catch (e: Exception) {
            throw IOException(e)
        }
    }
}