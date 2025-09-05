package com.example.itgproductapiapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.itgproductapiapp.data.api.model.Producto
import kotlin.collections.isNotEmpty

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    producto: Producto,
    onItemClick: (Producto) -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom =  8.dp),
        onClick = {
            onItemClick(producto)
        }
    ) {
        Row{
            if (producto.urlImagenes.isNotEmpty()) {
                AsyncImage(
                    model = producto.urlImagenes[0],
                    contentDescription = "Imagen del producto",
                    modifier = Modifier
                        .height(120.dp)
                        .aspectRatio(1f)
                )
            }
            Column(modifier = Modifier.padding(8.dp)){
                Text("${producto.nombre}")
                Text("${producto.precioRegular}")
                Text("${producto.codigoCategoria}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    ProductCard(
        modifier = Modifier.padding(8.dp),
        producto = Producto(
            nombre = "Producto 1",
        )
    )
}