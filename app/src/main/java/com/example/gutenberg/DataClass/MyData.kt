package com.example.gutenberg.DataClass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class MyData(
    val count: Int,
    val next: String?,
    val previous: @RawValue Any?,
    val results: List<Result>
):Parcelable