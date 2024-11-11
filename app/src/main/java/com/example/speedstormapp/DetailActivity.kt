package com.example.speedstormapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    private val list = ArrayList<Racer>()

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailName: TextView = findViewById(R.id.tv_racer_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_racer_description)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_racer_photo)

        val dataRacer = intent.getParcelableExtra<Racer>(EXTRA_NAME)

        tvDetailName.text = dataRacer?.name
        tvDetailDescription.text = dataRacer?.description
        ivDetailPhoto.setImageResource(dataRacer?.photo ?: 0)

    }
}