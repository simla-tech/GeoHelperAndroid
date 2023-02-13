package com.simla.geohelper.model.params.filter

import kotlinx.parcelize.Parcelize

@Parcelize
class PostCodeFilterParam private constructor(
    val cityId: String? = null,
    val streetId: String? = null,
    val houseNumber: String? = null,
    val housingNumber: String? = null,
    val structureNumber: String? = null
) : HashMap<String, String>(), GeoHelperFilter {

    class Builder(filter: PostCodeFilterParam? = null) {
        private var cityId: String? = filter?.cityId
        private var streetId: String? = filter?.streetId
        private var houseNumber: String? = filter?.houseNumber
        private var housingNumber: String? = filter?.housingNumber
        private var structureNumber: String? = filter?.structureNumber

        fun cityId(cityId: String?) = apply { this.cityId = cityId }
        fun streetId(streetId: String?) = apply { this.streetId = streetId }
        fun houseNumber(houseNumber: String?) = apply { this.houseNumber = houseNumber }
        fun housingNumber(housingNumber: String?) = apply { this.housingNumber = housingNumber }
        fun structureNumber(structureNumber: String?) =
            apply { this.structureNumber = structureNumber }

        fun build() = PostCodeFilterParam(
            cityId,
            streetId,
            houseNumber,
            housingNumber,
            structureNumber
        ).apply {
            cityId?.let { put(QUERY_PARAM_CITY_ID, it) }
            streetId?.let { put(QUERY_PARAM_STREET_ID, it) }
            houseNumber?.let { put(QUERY_PARAM_HOUSE_NUMBER, it) }
            housingNumber?.let { put(QUERY_PARAM_HOUSING_NUMBER, it) }
            structureNumber?.let { put(QUERY_PARAM_STRUCTURE_NUMBER, it) }
        }
    }

    companion object {
        const val QUERY_PARAM_CITY_ID = "filter[cityId]"
        const val QUERY_PARAM_STREET_ID = "filter[streetId]"
        const val QUERY_PARAM_HOUSE_NUMBER = "filter[houseNumber]"
        const val QUERY_PARAM_HOUSING_NUMBER = "filter[housingNumber]"
        const val QUERY_PARAM_STRUCTURE_NUMBER = "filter[structureNumber]"

        val EMPTY = PostCodeFilterParam()
    }
}