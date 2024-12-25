package com.example.gutenberg

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.gutenberg.databinding.ActivityDetailedBinding
import com.example.gutenberg.DataClass.Result
import com.squareup.picasso.Picasso
import java.io.File

class DetailedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getParcelableExtra<Result>("Data")
        if (result != null) {
            binding.bookTitleTextView.text = result.title
//            binding.bookTitleTextView.text = result.formats.application_rdf
            binding.bookAuthorTextView.text = result.authors.joinToString { it.name }
            binding.bookLanguageTextView.text = result.languages.joinToString()
            binding.bookCategoryTextView.text = result.subjects.joinToString()
            // Load image from formats.image_jpeg
            if (!result.formats.image_jpeg.isNullOrEmpty()) {
                Picasso.get().load(result.formats.image_jpeg).into(binding.bookImageView)
            }
            binding.btn.setOnClickListener{
                val url = Uri.parse(result.formats.text_utf)
                val intent= Intent(Intent.ACTION_VIEW,url)
                startActivity(intent)
            }
        }
    }
}