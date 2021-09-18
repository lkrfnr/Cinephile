package com.lkrfnr.cinephile.util

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

object MeasurementUtil {
    fun convertDpToPixel(dp: Float, context: Context): Float {
        return dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

    fun convertPixelsToDp(px: Float, context: Context): Float {
        return px / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

    fun getDeviceWidth(context: Context){
        var displayMetrics : DisplayMetrics = DisplayMetrics()
    }

    fun getWidth(): Int {
        return Resources.getSystem().displayMetrics.widthPixels
    }

    fun getHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }
}