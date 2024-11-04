package com.example.speedstormapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Racer(
    val name: String,
    val description: String,
    val photo: String
) : Parcelable
