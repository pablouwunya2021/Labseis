package com.example.laboratorio62


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.laboratorio62.networking.RetrofitInstance
import com.example.laboratorio62.repository.CategoryRepository
import com.example.laboratorio62.ui.CategoryScreen
import com.example.laboratorio62.viewmodel.CategoryViewModel
import com.example.laboratorio62.viewmodel.CategoryViewModelFactory

class CategoryActivity : ComponentActivity() {
    private lateinit var viewModel: CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crear una instancia del ViewModel
        val repository = CategoryRepository(RetrofitInstance.api)
        val viewModelFactory = CategoryViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CategoryViewModel::class.java)

        setContent {
            CategoryScreen(viewModel = viewModel)
        }
    }
}
