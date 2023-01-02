package com.example.apitestapplication.Network

import com.example.apitestapplication.Model.ProductModel
import retrofit2.Call
import retrofit2.http.GET

interface MyApiEndPoint{
    @GET("/products")
    fun getproductlist(): Call<ProductModel>
}