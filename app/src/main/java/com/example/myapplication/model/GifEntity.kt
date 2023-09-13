package com.example.myapplication.model

import com.google.gson.annotations.SerializedName


data class GifData(
    @SerializedName("data")
    val data: List<GifItem>
)

data class GifItem(
    @SerializedName("images")
    val images: GifImages
)

data class GifImages(
    @SerializedName("original")
    val original: GifOriginal
)

data class GifOriginal(
    @SerializedName("url")
    val url: String
)


