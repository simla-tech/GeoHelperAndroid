package com.simla.geohelper.model.response

import com.squareup.moshi.JsonClass
import com.simla.geohelper.model.response.result.ErrorResult
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class PostCodeResponse(
    override val success: Boolean,
    override val language: String,
    override val error: ErrorResult?,
    val result: String? = null
): BaseResponse(success, language, error)