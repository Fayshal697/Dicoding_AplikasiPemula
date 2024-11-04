package com.example.speedstormapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.speedstormapp.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // Inisialisasi View Binding
        val binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set data ke TextView menggunakan sumber daya string
        binding.tvName.text = getString(R.string.name)
        binding.tvEmail.text = getString(R.string.email)
        // Anda bisa menambahkan foto profil atau data lain di sini
    }
}
