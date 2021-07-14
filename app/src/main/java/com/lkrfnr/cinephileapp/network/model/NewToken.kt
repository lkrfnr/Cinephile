package com.lkrfnr.cinephileapp.network.model

import com.google.gson.annotations.SerializedName

data class NewToken(
    @SerializedName("expires_at")
    val expires_at: String,
    @SerializedName("request_token")
    val request_token: String,
    @SerializedName("success")
    val success: Boolean
)