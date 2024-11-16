package com.example.speedstormapp

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DetailActivity : AppCompatActivity() {
    private val list = ArrayList<Racer>()

    companion object {
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailName: TextView = findViewById(R.id.tv_racer_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_racer_description)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_racer_photo)

        val dataRacer: Racer? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_NAME, Racer::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_NAME)
        }

        tvDetailName.text = dataRacer?.name
        tvDetailDescription.text = dataRacer?.description
        ivDetailPhoto.setImageResource(dataRacer?.photo ?: 0)

    }
}