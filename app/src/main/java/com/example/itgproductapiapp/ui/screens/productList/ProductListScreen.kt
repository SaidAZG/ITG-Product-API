package com.example.itgproductapiapp.ui.screens.productList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.itgproductapiapp.ui.components.ProductCard
import kotlin.collections.get

@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.getProducts()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        if (state.value.isLoading) {
            Text(modifier = Modifier.align(Alignment.Center), text = "Cargando...")
        }else{
            if (state.value.error != null) {
                Text(text = state.value.error!!)
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize().align(Alignment.TopCenter),
                    contentPadding = PaddingValues(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    items(state.value.products.size) { index ->
                        val product = state.value.products[index]
                        ProductCard(producto = product)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductListScreenPreview() {
    ProductListScreen()
}