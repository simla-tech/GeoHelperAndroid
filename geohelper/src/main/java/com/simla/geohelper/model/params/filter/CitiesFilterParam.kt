package com.simla.geohelper.model.params.filter

import kotlinx.parcelize.Parcelize

@Parcelize
class CitiesFilterParam private constructor(
    val id: String? = null,
    val externalIds: Map<String, String>? = null,
    val ids: List<String>? = null,
    val regionId: String? = null,
    val regionCodes: List<String>? = null,
    val name: String? = null,
    val nameStrictLang: String? = null,
    val countryIso: String? = null
) : HashMap<String, String>(), GeoHelperFilter {

    class Builder(filter: CitiesFilterParam? = null) {
        private var id: String? = filter?.id
        private var externalIds: Map<String, String>? = filter?.externalIds
        private var ids: List<String>? = filter?.ids
        private var regionId: String? = filter?.regionId
        private var regionCodes: List<String>? = filter?.regionCodes
        private var name: String? = filter?.name
        private var nameStrictLang: String? = filter?.nameStrictLang
        private var countryIso: String? = filter?.countryIso

        fun id(id: String?) = apply { this.id = id }
        fun externalIds(externalIds: Map<String, String>?) = apply { this.externalIds = externalIds }
        fun ids(ids: List<String>?) = apply { this.ids = ids }
        fun regionId(cityId: String?) = apply { this.regionId = cityId }
        fun regionCodes(regionCodes: List<String>?) = apply { this.regionCodes = regionCodes }
        fun name(name: String?) = apply { this.name = name }
        fun nameStrictLang(lang: String?) = apply { this.nameStrictLang = lang }
        fun countryIso(iso: String?) = apply { this.countryIso = iso }

        fun build() = CitiesFilterParam(
            id,
            externalIds,
            ids,
            regionId,
            regionCodes,
            name,
            nameStrictLang,
            countryIso
        ).apply {
            id?.let { put(QUERY_PARAM_ID, it) }
            externalIds?.let {
                it.forEach { (key, value) ->
                    put(String.format(QUERY_PARAM_EXTERNAL_IDS, key), value)
                }
            }
            ids?.let { it.forEach { id -> put(QUERY_PARAM_IDS, id) } }
            regionId?.let { put(QUERY_PARAM_REGION_ID, it) }
            regionCodes?.let { put(QUERY_PARAM_REGION_CODES, it.toString()) }
            name?.let { put(QUERY_PARAM_NAME, it) }
            nameStrictLang?.let { put(QUERY_PARAM_NAME_STRICT_LANG, it) }
            countryIso?.let { put(QUERY_PARAM_COUNTRY_ISO, it) }
        }
    }

    companion object {
        const val QUERY_PARAM_ID = "filter[id]"
        const val QUERY_PARAM_EXTERNAL_IDS = "filter[externalIds][%s][]"
        const val QUERY_PARAM_IDS = "filter[ids]"
        const val QUERY_PARAM_REGION_ID = "filter[regionId]"
        const val QUERY_PARAM_REGION_CODES = "filter[regionCodes]"
        const val QUERY_PARAM_NAME = "filter[name]"
        const val QUERY_PARAM_NAME_STRICT_LANG = "filter[nameStrictLanguage]"
        const val QUERY_PARAM_COUNTRY_ISO = "filter[countryIso]"

        val EMPTY = CitiesFilterParam()
    }
}