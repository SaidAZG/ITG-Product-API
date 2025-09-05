package com.example.itgproductapiapp.data.api

import com.example.itgproductapiapp.data.api.model.ProductList
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {
    @GET("plp")
    suspend fun getProducts() : Response<ProductList>
}