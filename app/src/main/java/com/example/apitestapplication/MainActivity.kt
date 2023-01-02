package com.example.apitestapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apitestapplication.Adapters.ProductAdapter
import com.example.apitestapplication.Model.ProductModel
import com.example.apitestapplication.Model.ViewModel.MainViewModel
import com.example.apitestapplication.Network.MyApiEndPoint
import com.example.apitestapplication.Network.RetrofitClient
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var productModel: ProductModel
    lateinit var mainViewModel: MainViewModel
    lateinit var RecView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RecView=findViewById(R.id.rec_view)

        mainViewModel=ViewModelProvider(this)[MainViewModel::class.java]
        GetProducts()
        RecView.layoutManager=LinearLayoutManager(this)
        mainViewModel.productlist.observe(this){
            productModel=it
            RecView.adapter=ProductAdapter(productModel)
        }
    }
    fun GetProducts(){

        val client=RetrofitClient().getRetrofitInstance().create(MyApiEndPoint::class.java)
        val call=client.getproductlist()
        call.enqueue(object : Callback<ProductModel>{
            override fun onResponse(call: Call<ProductModel>, response: Response<ProductModel>) {
                if(response.isSuccessful){
                    productModel=response.body()!!
                    mainViewModel.productlist.value=productModel

                }else{
                   //Snackbar.make(    ,"Problem While Fetching Data From API!",Snackbar.LENGTH_SHORT).show()
                    Toast.makeText(this@MainActivity,"Problem While Fetching Data From API!",Toast.LENGTH_SHORT).show()

                }
            }

            override fun onFailure(call: Call<ProductModel>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Failed to connect to API!",Toast.LENGTH_SHORT).show()
            }

        })
    }
}