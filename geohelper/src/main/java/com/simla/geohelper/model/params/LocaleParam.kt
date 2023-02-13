package com.simla.geohelper.model.params

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class LocaleParam private constructor(
    val lang: String,
    val fallbackLang: String? = null
) : HashMap<String, String>(), Parcelable {

    class Builder(private val lang: String) {
        private var fallbackLang: String? = null

        fun fallbackLang(dir: String) = apply { this.fallbackLang = dir }

        fun build() = LocaleParam(lang, fallbackLang).apply {
            put(QUERY_PARAM_LANG, lang)
            fallbackLang?.let { put(QUERY_PARAM_FALLBACK_LANG, it) }
        }
    }

    companion object {
        const val QUERY_PARAM_LANG = "locale[lang]"
        const val QUERY_PARAM_FALLBACK_LANG = "locale[fallbackLang]"

        private const val LANG_DEFAULT = "en"

        val DEFAULT = LocaleParam(LANG_DEFAULT)
    }
}

