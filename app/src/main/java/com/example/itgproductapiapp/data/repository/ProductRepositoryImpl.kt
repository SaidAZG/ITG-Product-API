package com.example.itgproductapiapp.data.repository

import android.util.Log
import com.example.itgproductapiapp.data.api.ProductApi
import com.example.itgproductapiapp.data.api.model.Resultado
import com.example.itgproductapiapp.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val apiService: ProductApi
) : ProductRepository {
    override suspend fun getProducts() : Resultado? {
        try{
            val response = apiService.getProducts()
            if(response.isSuccessful){
                    val data = response.body()
                    return data?.resultado ?: throw Exception("Error al recibir la respuesta \nCódigo de respuesta ${response.code()}\nMensaje: ${response.message()}\"")
            }else{
                throw Exception("Error en la respuesta:\nCódigo de respuesta ${response.code()}\nMensaje: ${response.message()}")
            }
        }catch (e: Exception){
            Log.e("Error", e.message.toString())
        }
        return null
    }
}