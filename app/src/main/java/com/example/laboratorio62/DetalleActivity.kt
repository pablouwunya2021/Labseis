package com.example.laboratorio62



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio62.R

class DetalleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetalleEventoScreen()
        }
    }
}

@Composable
fun DetalleEventoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Encabezado
        //Encabezado()

        // Imagen principal (fondo rosa)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color(0xFFF48FB1)),  // Color rosa
            contentAlignment = Alignment.Center
        ) {
            Text("Imagen del evento", color = Color.White, fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sección de información
        SeccionInformacion()

        Spacer(modifier = Modifier.height(24.dp))

        // Botones de acción
        BotonesDeAccion()
    }
}

@Composable
fun encabezado() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("9:30", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.bateria),  // Reemplaza con un icono de batería en drawable
                contentDescription = "Icono de batería",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.triangulo),  // Reemplaza con un icono de menú
                contentDescription = "Menú",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun SeccionInformacion() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Lugar (opcional, incompleto)
        Text("Lugar", fontSize = 16.sp, color = Color.Gray, maxLines = 1)

        Spacer(modifier = Modifier.height(8.dp))

        // Título del evento
        Text(
            text = "Título del Evento",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Fecha y Hora
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.calendario),  // Reemplaza con un icono de calendario en drawable
                    contentDescription = "Fecha del evento",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("12 de Diciembre", fontSize = 16.sp)
            }
            Text("5:00 PM", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Descripción del evento
        Text(
            text = "Acerca de:\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam vehicula, felis non feugiat malesuada, purus felis ultricies libero.",
            fontSize = 14.sp
        )
    }
}

@Composable
fun BotonesDeAccion() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Botón de Favorito
        Button(
            onClick = { /* Acción para marcar como favorito */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EA)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            //Text("Favorite", color = Color.White)
        }

        // Botón de Comprar
        Button(
            onClick = { /* Acción para comprar o registrarse */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EA)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            //Text("Buy", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetalleEventoScreen() {
    DetalleEventoScreen()
}