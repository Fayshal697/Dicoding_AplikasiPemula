package com.example.speedstormapp

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class Racer(
    val name: String,
    val description: String,
    val photo: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt().toString()
    )

    companion object : Parceler<Racer> {

        override fun Racer.write(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
            parcel.writeString(description)
            parcel.writeInt(photo)
        }

        override fun create(parcel: Parcel): Racer {
            return Racer(parcel)
        }
    }
}

private fun Parcel.writeInt(photo: String) {

}
