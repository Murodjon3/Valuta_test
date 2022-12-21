package com.example.valuta_kursi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.valuta_kursi.Adapter.DataModel
import com.example.valuta_kursi.repository.AppRepository

class BViewModel : ViewModel(){
    val repository = AppRepository()

    val name = MutableLiveData<String>()

    val error = MutableLiveData<String>()
    val resultList = MutableLiveData<List<DataModel>>()
    val progress = MutableLiveData<Boolean>()

    fun loadResponse(){
        repository.getCourse(progress, resultList, error)
    }
}