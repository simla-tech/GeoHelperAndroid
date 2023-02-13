package com.simla.geohelper.model.entity

import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Country(
    override val id: String? = null,
    override val name: String? = null,
    val iso: String? = null,
    val iso3: String? = null,
    val isoNumeric: String? = null,
    val fips: String? = null,
    val continent: String? = null,
    val currencyCode: String? = null,
    val phonePrefix: List<String>? = null,
    val postalCodeFormat: String? = null,
    val postalCodeRegex: String? = null,
    val languages: List<String>? = null,
    val timezoneOffset: Int? = null,
    val externalIds: Map<String,String>? = null,
    val localizedNames: Map<String,String>? = null
) : GeoHelperEntity
