package com.example.itgproductapiapp.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.itgproductapiapp.ui.navigation.SelectedProduct

@Composable
fun MainScreen(
    product: SelectedProduct,
    goToProductList: () -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ){
            product.name?.let{
                Text(text = it)
            } ?: Text(text = "No has seleccionado\nningún producto", textAlign = TextAlign.Center)
        }
        Button(
            onClick = {
                goToProductList()
            }
        ) {
            Text(text = "Ver Lista de Productos")
        }
    }
}