package com.simla.geohelper.model.response.result

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import com.simla.geohelper.model.entity.Country
import com.simla.geohelper.model.entity.Region
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class PhoneDataResult(
    val id: String?,
    val dataSource: String?,
    val abcDefCode: Int?,
    val rangeStart: Int?,
    val rangeEnd: Int?,
    val providerName: String?,
    val region: Region?,
    val country: Country?,
    val phoneParts: Map<String,String>?
) : Parcelable
