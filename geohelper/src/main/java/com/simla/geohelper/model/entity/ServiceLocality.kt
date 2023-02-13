package com.simla.geohelper.model.entity

import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ServiceLocality(
    override val name: String? = null,
    val innerId: String? = null,
    val externalId: String? = null,
    val country: Country? = null,
    val localityType: String? = null,
    val localityTypeName: String? = null,
    val service: String? = null,
    val customData: Map<String,String>? = null,
    val data: Map<String,String>? = null
) : GeoHelperEntity {
    override val id: String?
        get() = innerId
}
