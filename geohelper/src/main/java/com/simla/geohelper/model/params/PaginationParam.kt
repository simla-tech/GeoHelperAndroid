package com.simla.geohelper.model.params

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class PaginationParam private constructor(
    val page: Int? = null,
    val limit: Int? = null
) : HashMap<String, String>(), Parcelable {

    class Builder {
        private var page: Int? = null
        private var limit: Int? = null

        fun page(page: Int) = apply { this.page = page }
        fun limit(limit: Int) = apply { this.limit = limit }

        fun build() = PaginationParam(page, limit).apply {
            page?.let { put(QUERY_PARAM_PAGE, it.toString()) }
            limit?.let { put(QUERY_PARAM_LIMIT, it.toString()) }
        }
    }

    companion object {
        const val QUERY_PARAM_PAGE = "pagination[page]"
        const val QUERY_PARAM_LIMIT = "pagination[limit]"

        val EMPTY = PaginationParam()
    }
}
