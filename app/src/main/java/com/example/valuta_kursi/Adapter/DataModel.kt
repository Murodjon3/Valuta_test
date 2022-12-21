package com.example.valuta_kursi.Adapter

import java.io.Serializable

data class DataModel(
    val Ccy: String,
    val Rate: String,
    val picture : Int
): Serializable