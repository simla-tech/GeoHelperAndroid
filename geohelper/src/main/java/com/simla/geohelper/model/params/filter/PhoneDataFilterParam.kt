package com.simla.geohelper.model.params.filter

import kotlinx.parcelize.Parcelize

@Parcelize
class PhoneDataFilterParam(
    val phone: String
) : HashMap<String, String>(), GeoHelperFilter {

    private constructor() : this("")

    init {
        if (phone.isNotBlank()) {
            put(QUERY_PARAM_FILTER_PHONE, phone)
        }
    }

    companion object {
        const val QUERY_PARAM_FILTER_PHONE = "filter[phone]"

        val EMPTY = PhoneDataFilterParam()
    }
}

