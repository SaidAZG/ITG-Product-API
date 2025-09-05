package com.example.itgproductapiapp.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.itgproductapiapp.ui.screens.main.MainScreen

@Composable
fun MainNavHost(
    modifier: Modifier
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navController,
        startDestination = MainScreen()
    ){
        composable<MainScreen>{ backStackEntry ->
            val selectedProduct = backStackEntry.toRoute<MainScreen>()
            MainScreen(
                product = SelectedProduct(
                    name = selectedProduct.name,
                    price = selectedProduct.price,
                    category = selectedProduct.category,
                    imageUrl = selectedProduct.imageUrl,
                ),
                goToProductList = { navController.navigate(ProductListScreen) }
            )
        }

        composable<ProductListScreen>{

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainNavHostPreview() {
    MainNavHost(
        modifier = Modifier
    )
}