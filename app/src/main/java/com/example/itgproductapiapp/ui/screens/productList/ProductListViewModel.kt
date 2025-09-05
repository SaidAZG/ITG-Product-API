package com.example.itgproductapiapp.ui.screens.productList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itgproductapiapp.data.api.model.Producto
import com.example.itgproductapiapp.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ProductListState())
    val state = _state.asStateFlow()

    fun getProducts() {
        viewModelScope.launch {
            Log.d("ProductListViewModel", "Fetching products...")
            getProductsUseCase()?.let { result ->
                _state.update {
                    it.copy(
                        products = result.productos
                    )
                }
            } ?: run {
                _state.update {
                    it.copy(
                        error = "Error al cargar los productos"
                    )
                }
            }
            _state.update {
                it.copy(
                    isLoading = false
                )
            }
        }
    }
}

data class ProductListState(
    val isLoading: Boolean = true,
    val products: List<Producto> = emptyList(),
    val error: String? = null
)