package com.example.laboratorio62


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import com.example.laboratorio62.ui.theme.Laboratorio62Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio62Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListaDeEventos()
                }
            }
        }
    }
}

// Modelo de datos para los eventos
data class Evento(
    val nombre: String,
    val lugar: String
)

// Lista de eventos de ejemplo
val eventosList = listOf(
    Evento("Concierto A", "Auditorio Nacional"),
    Evento("Festival B", "Foro Sol"),
    Evento("Show C", "Palacio de los Deportes"),
    Evento("Fiesta D", "Estadio Azteca")
)

@Composable
fun ListaDeEventos() {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(eventosList) { evento ->
            //EventItem(evento = evento)
        }
    }
}

@Composable
fun EventItem(evento: Evento) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Ícono circular con la letra inicial del nombre del evento
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = evento.nombre.first().toString(),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Información del evento
        Column(
            modifier = Modifier.weight(1f)
        ) {
            // Nombre del evento en negrita
            Text(
                text = evento.nombre,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            // Lugar del evento en texto normal
            Text(
                text = evento.lugar,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Triángulo sencillo usando texto (▲)
        Text(
            text = "▲",
            fontSize = 24.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEventItem() {
    Laboratorio62Theme {
        ListaDeEventos()
    }
}

