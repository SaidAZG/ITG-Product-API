package com.example.itgproductapiapp.data.api.model

import com.google.gson.Gson
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Producto(

    @SerialName("id") var id: String? = null,
    @SerialName("idLinea") var idLinea: Int? = null,
    @SerialName("codigoCategoria") var codigoCategoria: String? = null,
    @SerialName("idModalidad") var idModalidad: Int? = null,
    @SerialName("relevancia") var relevancia: Int? = null,
    @SerialName("lineaCredito") var lineaCredito: String? = null,
    @SerialName("pagoSemanalPrincipal") var pagoSemanalPrincipal: Int? = null,
    @SerialName("plazoPrincipal") var plazoPrincipal: Int? = null,
    @SerialName("disponibleCredito") var disponibleCredito: Boolean? = null,
    @SerialName("abonosSemanales") var abonosSemanales: ArrayList<AbonosSemanales> = arrayListOf(),
    @SerialName("sku") var sku: String? = null,
    @SerialName("nombre") var nombre: String? = null,
    @SerialName("urlImagenes") var urlImagenes: ArrayList<String> = arrayListOf(),
    @SerialName("precioRegular") var precioRegular: Int? = null,
    @SerialName("precioFinal") var precioFinal: Double? = null,
    @SerialName("porcentajeDescuento") var porcentajeDescuento: Double? = null,
    @SerialName("descuento") var descuento: Boolean? = null,
    @SerialName("precioCredito") var precioCredito: Double? = null,
    @SerialName("montoDescuento") var montoDescuento: Double? = null

)

fun Producto.toJson(): String {
    return Gson().toJson(this)
}

fun String.toProduct(): Producto? {
    return try {
        Gson().fromJson(this, Producto::class.java)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}