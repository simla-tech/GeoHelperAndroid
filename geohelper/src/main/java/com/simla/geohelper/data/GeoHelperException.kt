package com.simla.geohelper.data

import com.simla.geohelper.model.response.result.ErrorResult
import okio.IOException

sealed class GeoHelperException : IOException() {
    data class InvalidApiKey (val error: ErrorResult): GeoHelperException()
    data class BadRequest (val error: ErrorResult): GeoHelperException()
    data class HttpError (val code: Int): GeoHelperException()
    data class ApiError (val error: ErrorResult): GeoHelperException()
    object UnknownError : GeoHelperException()
}