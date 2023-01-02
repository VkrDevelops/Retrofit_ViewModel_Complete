package com.example.apitestapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apitestapplication.Model.getresponse
import com.example.apitestapplication.Network.MyApiEndPoint
import com.example.apitestapplication.Network.RetrofitClient
import com.example.apitestapplication.databinding.ActivityAddProductBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddProductActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPost.setOnClickListener { AddProduct() }
    }

    fun AddProduct() {
        val client = RetrofitClient().getRetrofitInstance().create(MyApiEndPoint::class.java)
        val call = client.addproduct(
            binding.title.text.toString(),
            binding.userID.text.toString().toInt(),
            binding.body.text.toString(),
            binding.tags.text.toString(),
            binding.reactions.text.toString()
        )
        call.enqueue(object : Callback<getresponse> {
            override fun onResponse(call: Call<getresponse>, response: Response<getresponse>) {
                if (response.isSuccessful){
                    val jhg=response.body()!!
                    Toast.makeText(this@AddProductActivity,"$jhg",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this@AddProductActivity,"Problem While Fetching Data From API!",Toast.LENGTH_SHORT).show()

                }
            }

            override fun onFailure(call: Call<getresponse>, t: Throwable) {
                Toast.makeText(this@AddProductActivity,"Failed to connect to API!",Toast.LENGTH_SHORT).show()
            }

        })
    }
}