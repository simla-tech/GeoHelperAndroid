package com.simla.geohelper.model.entity

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class LocalityType(
    val code: String? = null,
    val name: String? = null,
    val localizedNamesShort: Map<String, String>? = null,
    val localizedNames: Map<String, String>? = null
) : Parcelable