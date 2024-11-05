package com.example.speedstormapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.speedstormapp.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setContentView(binding.root)
    }
}
