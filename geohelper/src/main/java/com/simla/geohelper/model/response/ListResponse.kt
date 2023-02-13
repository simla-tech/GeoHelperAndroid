package com.simla.geohelper.model.response

import com.simla.geohelper.model.entity.GeoHelperEntity
import com.simla.geohelper.model.response.result.ErrorResult
import com.simla.geohelper.model.response.result.PaginationResult

abstract class ListResponse(
    override val success: Boolean,
    override val language: String,
    override val error: ErrorResult?,
    open val result: List<GeoHelperEntity>,
    open val pagination: PaginationResult
): BaseResponse(success, language, error)