package com.example.speedstormapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.speedstormapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    // Inisialisasi ViewBinding
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengatur binding untuk tampilan
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil data dari intent
        val name = intent.getStringExtra("EXTRA_NAME")
        val description = intent.getStringExtra("EXTRA_DESCRIPTION")
        val photo = intent.getStringExtra("EXTRA_PHOTO")

        // Mengatur data ke tampilan
        binding.tvDetailName.text = name
        binding.tvDetailDescription.text = description
        Glide.with(this).load(photo).into(binding.imgDetailPhoto)
    }
}