package com.example.myapplication.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.GifRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class GifViewModel : ViewModel() {
    private val repository = GifRepository()
    private val gifsLiveData = MutableLiveData<List<String>>()

    val gifs: LiveData<List<String>> get() = gifsLiveData

     fun loadGifs() {
        viewModelScope.launch(Dispatchers.IO) {
            val gifUrls = repository.getGifs()
            withContext(Dispatchers.Main) {
                gifsLiveData.value = gifUrls
            }
        }
    }
}