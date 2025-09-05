package com.example.itgproductapiapp.utils

import android.icu.text.NumberFormat
import java.util.Locale

fun Int.formatPrice() : String{
    val numberFormat = NumberFormat.getNumberInstance(Locale.getDefault())
    return numberFormat.format(this)
}