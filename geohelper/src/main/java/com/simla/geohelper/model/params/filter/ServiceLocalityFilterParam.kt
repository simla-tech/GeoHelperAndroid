package com.simla.geohelper.model.params.filter

import kotlinx.parcelize.Parcelize

@Parcelize
class ServiceLocalityFilterParam private constructor(
    val type: String? = null,
    val service: String? = null,
    val externalId: String? = null,
    val innerId: String? = null,
    val name: String? = null,
    val strictName: Boolean? = null,
    val countryIso: String? = null,
    val customData: List<String>? = null
) : HashMap<String, String>(), GeoHelperFilter {

    class Builder(filter: ServiceLocalityFilterParam? = null) {
        private var type: String? = filter?.type
        private var service: String? = filter?.service
        private var externalId: String? = filter?.externalId
        private var innerId: String? = filter?.innerId
        private var name: String? = filter?.name
        private var strictName: Boolean? = filter?.strictName
        private var countryIso: String? = filter?.countryIso
        private var customData: List<String>? = filter?.customData

        fun type(type: String?) = apply { this.type = type }
        fun service(service: String?) = apply { this.service = service }
        fun externalId(externalId: String?) = apply { this.externalId = externalId }
        fun innerId(innerId: String?) = apply { this.innerId = innerId }
        fun name(name: String?) = apply { this.name = name }
        fun strictName(enable: Boolean?) = apply { this.strictName = enable }
        fun customData(data: List<String>?) = apply { this.customData = data }

        fun build() = ServiceLocalityFilterParam(
            type,
            service,
            externalId,
            innerId,
            name,
            strictName,
            countryIso,
            customData
        ).apply {
            type?.let { put(QUERY_PARAM_TYPE, it) }
            service?.let { put(QUERY_PARAM_SERVICE, it) }
            externalId?.let { put(QUERY_PARAM_EXTERNAL_ID, it) }
            innerId?.let { put(QUERY_PARAM_INNER_ID, it) }
            name?.let { put(QUERY_PARAM_NAME, it) }
            strictName?.let { put(QUERY_PARAM_STRICT_NAME, it.toString()) }
            countryIso?.let { put(QUERY_PARAM_COUNTRY_ISO, it) }
            customData?.let { put(QUERY_PARAM_CUSTOM_DATA, it.toString()) }
        }
    }

    companion object {
        const val QUERY_PARAM_TYPE = "filter[type]"
        const val QUERY_PARAM_SERVICE = "filter[service]"
        const val QUERY_PARAM_EXTERNAL_ID = "filter[externalId]"
        const val QUERY_PARAM_INNER_ID = "filter[innerId]"
        const val QUERY_PARAM_NAME = "filter[name]"
        const val QUERY_PARAM_STRICT_NAME = "filter[strictName]"
        const val QUERY_PARAM_COUNTRY_ISO = "filter[countryIso]"
        const val QUERY_PARAM_CUSTOM_DATA = "filter[customData]"

        val EMPTY = ServiceLocalityFilterParam()
    }
}