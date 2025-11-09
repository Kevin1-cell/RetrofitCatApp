package com.example.retrofitcatapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CatViewModel : ViewModel() {
    private val _catUrl = MutableLiveData<String>()
    val catUrl: LiveData<String> get() = _catUrl

    fun fetchCat() {
        viewModelScope.launch {
            val response = RetrofitInstance.api.getRandomCat()
            _catUrl.value = response.firstOrNull()?.url
        }
    }
}
