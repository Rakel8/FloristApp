package com.example.floristapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Plant(
    val name: String,
    val description: String,
    // photoResourceName akan menyimpan nama file drawable (misalnya "tanaman1")
    val photoResourceName: String
) : Parcelable