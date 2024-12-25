package com.example.gutenberg.DataClass

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Formats(
    @SerializedName("application/epub+zip") val application_epub: String?,
    @SerializedName("application/octet-stream") val application_octet: String?,
    @SerializedName("application/rdf+xml") val application_rdf: String?,
    @SerializedName("application/x-mobipocket-ebook") val application_mobipocket: String?,
    @SerializedName("image/jpeg") val image_jpeg: String?,
    @SerializedName("text/html") val text_html: String?,
    @SerializedName("text/plain; charset=utf-8") val text_utf: String?,
    @SerializedName("text/plain; charset=us-ascii") val text_ascii: String?,
):Parcelable