package com.simla.geohelper.model.entity

import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Region(
    override val id: String? = null,
    override val name: String? = null,
    val timezoneOffset: Int? = null,
    val countryIso: String? = null,
    val codes: Map<String,String>? = null,
    val localityType: LocalityType? = null,
    val timezone: String? = null,
    val countryId: String? = null,
    val externalIds: Map<String,String>? = null,
    val localizedNames: Map<String,String>? = null
) : GeoHelperEntity