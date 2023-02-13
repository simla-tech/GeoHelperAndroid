package com.simla.geohelper.model.params.filter

import kotlinx.parcelize.Parcelize

@Parcelize
class CountriesFilterParam private constructor(
    val name: String? = null,
    val iso: String? = null,
    val iso3: String? = null,
    val fips: String? = null
) : HashMap<String, String>(), GeoHelperFilter {

    class Builder(filter: CountriesFilterParam? = null) {
        private var name: String? = filter?.name
        private var iso: String? = filter?.iso
        private var iso3: String? = filter?.iso3
        private var fips: String? = filter?.fips

        fun name(name: String?) = apply { this.name = name }
        fun iso(iso: String?) = apply { this.iso = iso }
        fun iso3(iso3: String?) = apply { this.iso3 = iso3 }
        fun fips(fips: String?) = apply { this.fips = fips }

        fun build() = CountriesFilterParam(name, iso, iso3, fips).apply {
            name?.let { put(QUERY_PARAM_NAME, it) }
            iso?.let { put(QUERY_PARAM_ISO, it) }
            iso3?.let { put(QUERY_PARAM_ISO3, it) }
            fips?.let { put(QUERY_PARAM_FIPS, it) }
        }
    }

    companion object {
        const val QUERY_PARAM_NAME = "filter[name]"
        const val QUERY_PARAM_ISO = "filter[iso]"
        const val QUERY_PARAM_ISO3 = "filter[iso3]"
        const val QUERY_PARAM_FIPS = "filter[fips]"

        val EMPTY = CountriesFilterParam()
    }
}