package com.example.itgproductapiapp.domain.repository

import com.example.itgproductapiapp.data.api.model.Resultado

interface ProductRepository {
    suspend fun getProducts(): Resultado?
}