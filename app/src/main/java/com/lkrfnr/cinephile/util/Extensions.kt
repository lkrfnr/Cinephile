package com.lkrfnr.cinephile.util


fun String.minToHour() : String{

    val minInt : Int? = this.toIntOrNull()
    val hourStr : String = (minInt?.div(60) ).toString()
    val reminderMin : String = minInt?.rem(60).toString()

    return "${hourStr}hr ${reminderMin}m"
}