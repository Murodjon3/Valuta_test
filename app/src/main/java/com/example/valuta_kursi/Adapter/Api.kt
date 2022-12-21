package com.example.valuta_kursi.Adapter


import retrofit2.http.GET

interface Api {
       @GET("json")
       fun getCourse(): retrofit2.Call<List<DataModel>>
}