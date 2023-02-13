package com.simla.geohelper.model.params

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class OrderParam (
    val by: String,
    val dir: DIR = DIR.ASC
) : HashMap<String, String>(), Parcelable {

    private constructor() : this("")

    init {
        if (by.isNotBlank()) {
            put(QUERY_PARAM_BY, by)
            put(QUERY_PARAM_DIR, dir.toString().lowercase())
        }
    }

    enum class DIR {
        ASC,
        DESC
    }

    companion object {
        const val QUERY_PARAM_BY = "order[by]"
        const val QUERY_PARAM_DIR = "order[dir]"

        val DEFAULT = OrderParam()
    }
}

