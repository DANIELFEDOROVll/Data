package com.example.appforretrofit.Retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("comments")
    suspend fun getProductById(): Osnova
}