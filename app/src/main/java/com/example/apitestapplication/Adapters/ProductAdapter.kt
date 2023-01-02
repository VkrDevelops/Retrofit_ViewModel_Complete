package com.example.apitestapplication.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apitestapplication.Model.Product
import com.example.apitestapplication.Model.ProductModel
import com.example.apitestapplication.R
import com.example.apitestapplication.databinding.CustomeRecyclerDesignBinding

class ProductAdapter(private val products: ProductModel) :
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {
    private lateinit var binding: CustomeRecyclerDesignBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding= CustomeRecyclerDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(products.products[position])
    }

    override fun getItemCount() = products.products.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(dta: Product) {
            binding.brand.text = dta.brand
            binding.category.text = dta.category
            binding.description.text = dta.description
            binding.discount.text = dta.discountPercentage.toString()
            binding.id.text = dta.id.toString()
            binding.price.text = dta.price.toString()
            binding.rating.rating = dta.rating.toFloat()
            binding.stock.text = dta.stock.toString()
            binding.title.text = dta.title
            Glide.with(itemView.context).load(dta.thumbnail).fitCenter().into(binding.thumbnail)
            binding.imagesRecView.adapter = ImagesAdapter(dta.images)
        }
    }
}
