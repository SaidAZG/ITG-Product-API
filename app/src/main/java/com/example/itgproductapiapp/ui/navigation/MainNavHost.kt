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
import com.example.itgproductapiapp.ui.screens.productList.ProductListScreen
import com.google.gson.Gson

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
                product = selectedProduct.selectedProductDetail,
                goToProductList = { navController.navigate(ProductListScreen) }
            )
        }

        composable<ProductListScreen>{
            ProductListScreen(
                showProduct = { product ->
                    navController.navigate(MainScreen(product))
                }
            )
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