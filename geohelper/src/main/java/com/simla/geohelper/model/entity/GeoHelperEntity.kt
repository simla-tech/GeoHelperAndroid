package com.simla.geohelper.model.entity

import android.os.Parcelable

interface GeoHelperEntity : Parcelable {
    val id: String?
    val name: String?
}