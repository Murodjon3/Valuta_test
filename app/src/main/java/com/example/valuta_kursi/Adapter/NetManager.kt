package com.example.valuta_kursi.Adapter

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory.*


object NetManager {
    var retrofit: Retrofit? = null
    var api: Api? = null

    fun getApiService(): Api {
        if (api == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://cbu.uz/uz/arkhiv-kursov-valyut/")
                .addConverterFactory(create())
                .build()
            api = retrofit!!.create(Api::class.java)
        }
        return api!!
    }

}