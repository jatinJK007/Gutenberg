package com.example.gutenberg.DataClass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Translator(
    val birth_year: @RawValue Any,
    val death_year: @RawValue Any,
    val name: String
):Parcelable