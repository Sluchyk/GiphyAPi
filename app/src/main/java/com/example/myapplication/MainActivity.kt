package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.GifViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
        @SuppressLint("NotifyDataSetChanged")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val gifs = mutableListOf<String>()
            val adapter = GifRecycleViewAdapter(this, gifs)

            val recyclerView = findViewById<RecyclerView>(R.id.recycleView)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)

            val viewModel = ViewModelProvider(this)[GifViewModel::class.java]
            CoroutineScope(Dispatchers.IO).launch{
            viewModel.loadGifs()
            }
            viewModel.gifs.observe(this) { gifUrls ->
                println(gifs)
                gifs.clear()
                gifs.addAll(gifUrls)
                adapter.notifyDataSetChanged()
            }
        }
    }

