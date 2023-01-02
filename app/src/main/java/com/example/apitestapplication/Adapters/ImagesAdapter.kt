package com.example.apitestapplication.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apitestapplication.R
import com.example.apitestapplication.databinding.CustomImageRecyclerBinding

class ImagesAdapter(private val images: List<String>) : RecyclerView.Adapter<ImagesAdapter.MyImagesViewHolder>() {

    private lateinit var binding: CustomImageRecyclerBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyImagesViewHolder {
        binding= CustomImageRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyImagesViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyImagesViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount()= images.size

    inner class MyImagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(link: String)
        {
            Glide.with(itemView.context).load(link).fitCenter().into(binding.productimage)
        }
    }
}


