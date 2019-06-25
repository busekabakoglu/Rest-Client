package com.example.restclient4

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://github-trending-api.now.sh/"

interface APISerivce{
    @GET("repositories")
    fun  getUsers() : Call<List<User>>
}