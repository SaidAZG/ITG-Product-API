package com.example.itgproductapiapp.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
data class MainScreen(
    val selectedProductDetail: String? = null
)

@Serializable
data object ProductListScreen