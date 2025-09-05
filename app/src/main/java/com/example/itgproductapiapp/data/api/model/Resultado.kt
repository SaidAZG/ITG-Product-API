package com.example.itgproductapiapp.data.api.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Resultado(

    @SerialName("paginacion") var paginacion: Paginacion? = Paginacion(),
    @SerialName("categoria") var categoria: String? = null,
    @SerialName("productos") var productos: ArrayList<Producto> = arrayListOf()

)