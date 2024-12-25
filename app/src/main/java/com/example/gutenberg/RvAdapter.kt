package com.example.gutenberg

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gutenberg.DataClass.Result
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class RvAdapter(val context : Activity, val bookList:List<Result>):
    RecyclerView.Adapter<RvAdapter.MyViewHolder>()
{
    lateinit var onItemClick: ((Result) -> Unit)
//    added later to implement the detailed functionality

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem, parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        val currentItem = bookList[position]
        holder.author.text= currentItem.authors.toString()
        holder.dcount.text= currentItem.download_count.toString()
        holder.title.text= currentItem.title
        Picasso.get().load(currentItem.formats.image_jpeg).into(holder.image);
//        called in clicking the crad item of rv
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var title: TextView
        var image : ShapeableImageView
        var author:TextView
        var dcount:TextView

        init{
            title = itemView.findViewById(R.id.bookTitle)
            image = itemView.findViewById(R.id.booktImage)
            author = itemView.findViewById(R.id.author)
            dcount = itemView.findViewById(R.id.dCount)
        }
    }

}