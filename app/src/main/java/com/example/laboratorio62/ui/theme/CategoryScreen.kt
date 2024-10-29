package com.example.laboratorio62.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.laboratorio62.networking.Category
import com.example.laboratorio62.viewmodel.CategoryViewModel

@Composable
fun CategoryScreen(viewModel: CategoryViewModel) {
    val categories = viewModel.categories.collectAsState().value

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(categories) { category ->
            CategoryItem(category = category)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun CategoryItem(category: Category) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter(category.strCategoryThumb),
            contentDescription = category.strCategory,
            modifier = Modifier.size(50.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = category.strCategory,
                fontSize = 20.sp,
                color = Color.Black
            )
            Text(
                text = category.strCategoryDescription,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}
