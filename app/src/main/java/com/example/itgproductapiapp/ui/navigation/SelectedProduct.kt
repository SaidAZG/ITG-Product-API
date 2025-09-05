package com.example.itgproductapiapp.ui.navigation

data class SelectedProduct (
    val name: String? = null,
    val price: Int? = null,
    val imageUrl: List<String>? = null,
    val category: String? = null
)