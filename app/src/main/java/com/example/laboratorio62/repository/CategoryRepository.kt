package com.example.laboratorio62.repository



import com.example.laboratorio62.networking.ApiService
import com.example.laboratorio62.networking.Category

class CategoryRepository(private val apiService: ApiService) {
    suspend fun getCategories(): List<Category> {
        return apiService.getCategories().categories
    }
}
