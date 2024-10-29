package com.example.laboratorio62

data class CategoryResponse(val categories: List<Category>)
data class Category(val idCategory: String, val strCategory: String, val strCategoryThumb: String)

data class MealResponse(val meals: List<Meal>)
data class Meal(val idMeal: String, val strMeal: String, val strMealThumb: String)

data class MealDetailResponse(val meals: List<MealDetail>)
data class MealDetail(val idMeal: String, val strMeal: String, val strInstructions: String, val strMealThumb: String)
