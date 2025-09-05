package com.example.itgproductapiapp.data.api.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Paginacion(

    @SerialName("pagina") var pagina: Int? = null,
    @SerialName("totalPaginas") var totalPaginas: Int? = null,
    @SerialName("totalRegistros") var totalRegistros: Int? = null,
    @SerialName("totalRegistrosPorPagina") var totalRegistrosPorPagina: Int? = null

)