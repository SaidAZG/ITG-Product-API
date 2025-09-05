package com.example.itgproductapiapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.itgproductapiapp.data.api.model.Producto
import com.example.itgproductapiapp.ui.theme.productDescription
import com.example.itgproductapiapp.ui.theme.productName
import com.example.itgproductapiapp.ui.theme.productPrice

@Composable
fun DetailedProductCard(
    modifier: Modifier = Modifier,
    producto: Producto,
){
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column{
            if (producto.urlImagenes.isNotEmpty()) {
                val pagerState = rememberPagerState(pageCount = { producto.urlImagenes.size })

                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                ) { pageIndex ->
                    AsyncImage(
                        model = producto.urlImagenes[pageIndex],
                        contentDescription = "Imagen del producto ${pageIndex + 1}",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                if (pagerState.pageCount > 1) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding( 16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        repeat(pagerState.pageCount) { iteration ->
                            val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                            Box(
                                modifier = Modifier
                                    .padding(2.dp)
                                    .clip(RectangleShape)
                                    .weight(1f)
                                    .size(3.dp)
                                    .background(color)
                            )
                        }
                    }
                }else{
                    Spacer(modifier = Modifier.padding(top = 16.dp))
                }
            }else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No hay imagen disponible")
                }
            }
            Column(modifier = Modifier.padding( start = 16.dp, end = 16.dp, bottom = 16.dp)){
                Text("${producto.nombre}", style = productName)
                Text("Precio Regular: $ ${producto.precioRegular}", style = productPrice)
                Text("Categoría: ${producto.codigoCategoria}", style = productDescription)
            }
        }
    }
}

@Preview
@Composable
fun DetailedProductCardPreview() {
    DetailedProductCard(
        modifier = Modifier.padding(8.dp),
        producto = Producto(
            nombre = "Producto 1",
            precioRegular = 10000,
            urlImagenes = arrayListOf("https://picsum.photos/200/300"),
            codigoCategoria = "LM"
        )
    )
}

@Preview
@Composable
fun DetailedProductCardPreviewNoImage() {
    DetailedProductCard(
        modifier = Modifier.padding(8.dp),
        producto = Producto(
            nombre = "Producto 1",
            precioRegular = 10000,
            urlImagenes = arrayListOf(),
            codigoCategoria = "LM"
        )
    )
}