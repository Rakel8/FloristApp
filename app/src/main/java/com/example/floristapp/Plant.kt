package com.example.floristapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Plant(
    val name: String,
    val description: String,
    val photoResourceName: String
) : Parcelable