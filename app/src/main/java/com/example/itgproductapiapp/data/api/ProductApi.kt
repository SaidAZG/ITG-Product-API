package com.example.itgproductapiapp.data.api

import retrofit2.http.GET

interface ProductApi {
    @GET("plp")
    suspend fun getProducts()
}