package com.simla.geohelper.model.response

import com.squareup.moshi.JsonClass
import com.simla.geohelper.model.response.result.ErrorResult
import com.simla.geohelper.model.response.result.PhoneDataResult
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class PhoneDataResponse(
    override val success: Boolean,
    override val language: String,
    override val error: ErrorResult?,
    val result: PhoneDataResult?
) : BaseResponse(success, language, error)