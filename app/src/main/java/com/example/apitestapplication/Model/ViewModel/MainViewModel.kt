package com.example.apitestapplication.Model.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apitestapplication.Model.ProductModel

class MainViewModel(): ViewModel() {
    val productlist=MutableLiveData<ProductModel>()
}