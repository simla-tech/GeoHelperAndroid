package com.simla.geohelper.model.entity

import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class District(
    override val id: String? = null,
    override val name: String? = null,
    val localityType: LocalityType? = null,
    val cityId: String? = null,
    val externalIds: Map<String, String>? = null,
    val localizedNames: Map<String, String>? = null
) : GeoHelperEntity