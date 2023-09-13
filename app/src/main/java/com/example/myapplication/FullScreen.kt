package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class FullScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen)
        val imageUrl = intent.getStringExtra("image_url")
        val imageView: ImageView = findViewById(R.id.fullScreenActivity)
        Glide.with(this)
            .load(imageUrl)
            .into(imageView)
         val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            finish()
        }
    }
    }
