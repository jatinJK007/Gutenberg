package com.example.gutenberg

import com.example.gutenberg.DataClass.MyData
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("books/")
    fun getData() :Call<MyData>
}