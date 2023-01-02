package com.example.apitestapplication.Network

import com.example.apitestapplication.Model.ProductModel
import com.example.apitestapplication.Model.getresponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApiEndPoint{
    @GET("/products")
    fun getproductlist(): Call<ProductModel>

    @FormUrlEncoded
    @POST("/products/add")
    fun addproduct(
        @Field ("title") title:String,
        @Field ("userId") userId:Int,
        @Field ("body") body:String,
        @Field ("tags") tags:String,
        @Field ("reactions") reactions:String
    ): Call<getresponse>
}