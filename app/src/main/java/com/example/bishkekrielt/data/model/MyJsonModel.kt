package com.example.bishkekrielt.data.model

import com.google.gson.annotations.SerializedName


data class Data (
    val catalog: List<Recatalog> )

data class Recatalog (
    @SerializedName("title") val title: String,
    @SerializedName ("price")val price: String

    )



