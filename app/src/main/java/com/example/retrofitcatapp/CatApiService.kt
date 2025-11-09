package com.example.retrofitcatapp

import retrofit2.http.GET

interface CatApiService {
    @GET("images/search")
    suspend fun getRandomCat(): List<CatResponse>
}

data class CatResponse(val url: String)
