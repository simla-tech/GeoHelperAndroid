package com.simla.geohelper.model.response

import android.os.Parcelable
import com.simla.geohelper.model.response.result.ErrorResult

abstract class BaseResponse(
    open val success: Boolean,
    open val language: String,
    open val error: ErrorResult?
): Parcelable