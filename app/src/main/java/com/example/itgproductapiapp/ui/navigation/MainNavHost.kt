package com.example.itgproductapiapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        modifier = modifier,
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
                )
            )
        }

        composable<ProductListScreen>{

        }
    }
}