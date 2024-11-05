package com.example.speedstormapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    private val list = ArrayList<Racer>()

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val ivDetailPhoto: ImageView = findViewById(R.id.img_detail_photo)

        val dataRacer = intent.getParcelableExtra<Racer>(EXTRA_PERSON)

        tvDetailName.text = dataRacer?.name
        tvDetailDescription.text = dataRacer?.description
        ivDetailPhoto.setImageResource((dataRacer?.photo ?: 0) as Int)
    }
}

