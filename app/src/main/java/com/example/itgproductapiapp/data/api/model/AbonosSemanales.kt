package com.example.itgproductapiapp.data.api.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class AbonosSemanales(

    @SerialName("plazo") var plazo: Int? = null,
    @SerialName("montoAbono") var montoAbono: Int? = null,
    @SerialName("montoDescuentoAbono") var montoDescuentoAbono: Int? = null,
    @SerialName("montoUltimoAbono") var montoUltimoAbono: Int? = null,
    @SerialName("montoFinalCredito") var montoFinalCredito: Int? = null,
    @SerialName("idPromocion") var idPromocion: Int? = null,
    @SerialName("montoDescuentoElektra") var montoDescuentoElektra: Int? = null,
    @SerialName("montoDescuentoBanco") var montoDescuentoBanco: Int? = null,
    @SerialName("precio") var precio: Int? = null,
    @SerialName("montoAbonoDigital") var montoAbonoDigital: Int? = null

)