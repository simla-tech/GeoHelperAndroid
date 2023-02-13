package com.simla.geohelper.model.response.result

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ErrorResult(
    val code: Int?,
    val message: String,
    val details: List<String> = emptyList()
): Parcelable {

    companion object {
        const val JSON_OBJECT_NAME = "error"
    }
}