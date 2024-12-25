package com.example.gutenberg

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gutenberg.DataClass.MyData
import com.example.gutenberg.DataClass.Result
import com.example.gutenberg.databinding.ActivityMainBinding
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var myAdapter:RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        var rv = binding.rv
        val retrofirBuilder = Retrofit.Builder()
            .baseUrl("https://gutendex.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofirBuilder.getData()


        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                var responseBody= response.body()
                var productList= responseBody?.results?: emptyList()
                //    we have added ? if there is a null value from the api then the function will not get called further

                myAdapter= RvAdapter(this@MainActivity, productList)
                rv.adapter= myAdapter
                rv.layoutManager =LinearLayoutManager(this@MainActivity)
                myAdapter.onItemClick ={result ->
                    val intent = Intent(this@MainActivity, DetailedActivity::class.java)
                    intent.putExtra("Data",result)
                    startActivity(intent)
                }
            }
            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("TAG", "onFailure: "+t.message)
                binding.tv.text= "failed to load data:"
            }
        })
    }
}