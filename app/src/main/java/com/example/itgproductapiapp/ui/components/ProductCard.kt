package com.example.itgproductapiapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.itgproductapiapp.data.api.model.Producto
import com.example.itgproductapiapp.ui.theme.productDescription
import com.example.itgproductapiapp.ui.theme.productName
import com.example.itgproductapiapp.ui.theme.productPrice
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
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ),
        onClick = {
            onItemClick(producto)
        }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically){
            if (producto.urlImagenes.isNotEmpty()) {
                AsyncImage(
                    model = producto.urlImagenes[0],
                    contentDescription = "Imagen del producto",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(120.dp)
                        .aspectRatio(1f)
                )
            }
            Column(modifier = Modifier.padding(horizontal = 8.dp)){
                Text("${producto.nombre}", style = productName)
                Text("$ ${producto.precioRegular}", style = productPrice)
                Text("Categoría: ${producto.codigoCategoria}", style = productDescription)
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
            precioRegular = 10000,
            urlImagenes = arrayListOf("https://picsum.photos/200/300"),
            codigoCategoria = "LM"
        )
    )
}