package com.example.valuta_kursi.repository

import androidx.lifecycle.MutableLiveData
import com.example.valuta_kursi.Adapter.DataModel
import com.example.valuta_kursi.Adapter.HomeAdapter
import com.example.valuta_kursi.Adapter.NetManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppRepository {
    fun getCourse(
        progress: MutableLiveData<Boolean>,
        resultList: MutableLiveData<List<DataModel>>,
        error: MutableLiveData<String>
    ){
        NetManager.getApiService().getCourse().enqueue(object : Callback<List<DataModel>> {
            override fun onResponse(
                call: Call<List<DataModel>>,
                response: Response<List<DataModel>>
            ) {
                if (response.isSuccessful) {
                    resultList.value = response.body()
                    progress.value = false
                }
            }

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
            error.value = t.localizedMessage?.toString()
                progress.value = false

            }
        })

    }
}