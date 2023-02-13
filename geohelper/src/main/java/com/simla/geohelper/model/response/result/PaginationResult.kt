package com.simla.geohelper.model.response.result

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class PaginationResult(
    val limit: Int?,
    val totalCount: Int?,
    val currentPage: Int?,
    val totalPageCount: Int?
) : Parcelable
