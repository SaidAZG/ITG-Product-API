package com.example.itgproductapiapp.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
data class MainScreen(
    val name: String? = null,
    val price: Double? = null,
    val imageUrl: List<String>? = null,
    val category: String? = null
)

@Serializable
data object ProductListScreen