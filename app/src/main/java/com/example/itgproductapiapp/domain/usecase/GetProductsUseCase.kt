package com.example.itgproductapiapp.domain.usecase

import com.example.itgproductapiapp.data.api.model.Resultado
import com.example.itgproductapiapp.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val productsRepository: ProductRepository
){
    suspend operator fun invoke() : Resultado? = productsRepository.getProducts()
}