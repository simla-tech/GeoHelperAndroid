package com.simla.geohelper.model.params.filter

import kotlinx.parcelize.Parcelize

@Parcelize
class StreetsFilterParam private constructor(
    val id: String? = null,
    val externalIds: Map<String, String>? = null,
    val ids: List<String>? = null,
    val cityId: String? = null,
    val name: String? = null,
    val cityExternalIdCode: String? = null
) : HashMap<String, String>(), GeoHelperFilter {

    class Builder(filter: StreetsFilterParam? = null) {
        private var id: String? = filter?.id
        private var externalIds: Map<String, String>? = filter?.externalIds
        private var ids: List<String>? = filter?.ids
        private var cityId: String? = filter?.cityId
        private var name: String? = filter?.name
        private var cityExternalIdCode: String? = filter?.cityExternalIdCode

        fun id(id: String?) = apply { this.id = id }
        fun externalIds(externalIds: Map<String, String>?) = apply { this.externalIds = externalIds }
        fun ids(ids: List<String>?) = apply { this.ids = ids }
        fun cityId(cityId: String?) = apply { this.cityId = cityId }
        fun name(name: String?) = apply { this.name = name }
        fun cityExternalIdCode(code: String?) = apply { this.cityExternalIdCode = code }

        fun build() = StreetsFilterParam(
            id,
            externalIds,
            ids,
            cityId,
            name,
            cityExternalIdCode
        ).apply {
            id?.let { put(QUERY_PARAM_ID, it) }
            externalIds?.let {
                it.forEach { (key, value) ->
                    put(String.format(QUERY_PARAM_EXTERNAL_IDS, key), value)
                }
            }
            ids?.let { it.forEach { id -> put(QUERY_PARAM_IDS, id) } }
            cityId?.let { put(QUERY_PARAM_CITY_ID, it) }
            name?.let { put(QUERY_PARAM_NAME, it) }
            cityExternalIdCode?.let { put(QUERY_PARAM_CITY_EXTERNAL_ID, it) }
        }
    }

    companion object {
        const val QUERY_PARAM_ID = "filter[id]"
        const val QUERY_PARAM_EXTERNAL_IDS = "filter[externalIds][%s][]"
        const val QUERY_PARAM_IDS = "filter[ids]"
        const val QUERY_PARAM_CITY_ID = "filter[cityId]"
        const val QUERY_PARAM_NAME = "filter[name]"
        const val QUERY_PARAM_CITY_EXTERNAL_ID = "filter[cityExternalIdCode]"

        val EMPTY = StreetsFilterParam()
    }
}
