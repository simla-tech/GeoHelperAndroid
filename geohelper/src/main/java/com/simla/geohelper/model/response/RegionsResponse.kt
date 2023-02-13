package com.simla.geohelper.model.response

import com.squareup.moshi.JsonClass
import com.simla.geohelper.model.entity.Region
import com.simla.geohelper.model.response.result.ErrorResult
import com.simla.geohelper.model.response.result.PaginationResult
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class RegionsResponse(
    override val success: Boolean,
    override val language: String,
    override val error: ErrorResult?,
    override val result: List<Region> = emptyList(),
    override val pagination: PaginationResult
): ListResponse(success, language, error, result, pagination)