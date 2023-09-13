package com.example.myapplication

import com.example.myapplication.model.GifData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GifApi {
    @GET("search?api_key=YGHnKKBGSydS6nSt6WAoUcICWwmgCfvL&q=cat&limit=25&offset=0&lang=en")
    suspend fun getListOfGif(): GifData
}

class GifRepository {
    private val api: GifApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.giphy.com/v1/gifs/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(GifApi::class.java)
    }

    suspend fun getGifs(): List<String> {
        return try {
            val gifData = api.getListOfGif()
            mapGifDataToUrls(gifData)
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    private fun mapGifDataToUrls(gifData: GifData): List<String> {
        val list = mutableListOf<String>()
        for (item in gifData.data) {
            list.add(item.images.original.url)
        }
        return list
    }
}
