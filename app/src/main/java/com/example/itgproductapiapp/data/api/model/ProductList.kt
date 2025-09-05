package com.example.itgproductapiapp.data.api.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class ProductList(

    @SerialName("mensaje") var mensaje: String? = null,
    @SerialName("advertencia") var advertencia: String? = null,
    @SerialName("resultado") var resultado: Resultado? = Resultado()

)