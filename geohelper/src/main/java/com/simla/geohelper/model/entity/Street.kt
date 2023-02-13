package com.simla.geohelper.model.entity

import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Street(
    override val id: String? = null,
    override val name: String? = null,
    val postCode: String? = null,
    val codes: Map<String, String>? = null,
    val cityId: String? = null,
    val districtId: String? = null,
    val parentStreetId: String? = null,
    val localityType: LocalityType? = null,
    val externalIds: Map<String, String>? = null,
    val localizedNames: Map<String, String>? = null
) : GeoHelperEntity