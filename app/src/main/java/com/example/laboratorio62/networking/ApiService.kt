package com.example.laboratorio62.networking

import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): CategoryResponse
}
