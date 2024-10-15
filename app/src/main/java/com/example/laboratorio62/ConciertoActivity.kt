package com.example.laboratorio62


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio62.R

class ConciertosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaFavoritos()
        }
    }
}

@Composable
fun PantallaFavoritos() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Encabezado
        // Encabezado()

        Spacer(modifier = Modifier.height(16.dp))

        // Título de la sección de favoritos
        Text(
            text = "Your favorites",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Cuadrícula de eventos favoritos
        CuadrillaDeEventosFavoritos()

        Spacer(modifier = Modifier.height(16.dp))

        // Enlace a todos los conciertos
        Text(
            text = "All Concerts",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable { /* Acción para ver todos los conciertos */ }
        )
    }
}

@Composable
fun Encabezado() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "9:30",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "TodoEventos",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Icon(
            painter = painterResource(id = R.drawable.triangulo),  // Icono de menú desplegable
            contentDescription = "Menú desplegable",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun CuadrillaDeEventosFavoritos() {
    val eventos = listOf(
        EventoFavorito(R.drawable.greenday, "Title 1", "Supporting text 1"),

        )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),  // Dos columnas
        modifier = Modifier.fillMaxHeight(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(eventos) { evento ->
            TarjetaDeEvento(evento)
        }
    }
}

@Composable
fun TarjetaDeEvento(evento: EventoFavorito) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            // Imagen del evento
            Image(
                painter = painterResource(id = evento.imagenResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Título del evento
            Text(
                text = evento.titulo,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            // Texto de apoyo
            Text(
                text = evento.textoApoyo,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

// Clase de datos para los eventos favoritos
data class EventoFavorito(val imagenResId: Int, val titulo: String, val textoApoyo: String)

@Preview(showBackground = true)
@Composable
fun PreviewPantallaFavoritos() {
    PantallaFavoritos()
}