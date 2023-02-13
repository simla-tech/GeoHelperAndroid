package com.simla.geohelper.model.entity

import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class City(
    override val id: String? = null,
    override val name: String? = null,
    val localityType: LocalityType? = null,
    val parentCityId: String? = null,
    val area: String? = null,
    val codes: Map<String,String>? = null,
    val postCode: String? = null,
    val population: Int? = null,
    val regionId: String? = null,
    val externalIds: Map<String,String>? = null,
    val localizedNames: Map<String,String>? = null
) : GeoHelperEntity