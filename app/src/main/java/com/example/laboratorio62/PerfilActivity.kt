package com.example.laboratorio62

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio62.R

class PerfilActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMainScreen()  // Pantalla principal con barra de navegación
        }
    }
}

// Función principal que contiene la barra de navegación y la navegación entre pantallas
@Composable
fun AppMainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        NavigationGraph(navController, Modifier.padding(innerPadding))
    }
}

// Barra de navegación simple sin iconos, solo con los nombres de las pantallas
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomNavigation {
        val items = listOf("Perfil", "Pantalla2", "Pantalla3", "Pantalla4")

        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Spacer(modifier = Modifier.size(0.dp)) }, // Espacio vacío para icono
                label = { Text(screen) },
                selected = false, // Aquí puedes implementar la lógica para la selección
                onClick = {
                    navController.navigate(screen)
                }
            )
        }
    }
}

// Función que gestiona la navegación entre pantallas
@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = "Perfil", modifier = modifier) {
        composable("Perfil") { PerfilScreen() }
        composable("Pantalla2") { ListaDeEventos() }
        composable("Pantalla3") { DetalleEventoScreen() }
        composable("Pantalla4") { PantallaFavoritos() }
    }
}

// Pantalla de perfil que ya tenías creada
@Composable
fun PerfilScreen() {
    var notificacionesEnabled by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF6200EA),
                        Color(0xFFBB86FC),
                        Color(0xFF03DAC5)
                    )
                )
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(Color.LightGray, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.greenday),
                    contentDescription = "Ícono de usuario",
                    modifier = Modifier.size(60.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Cecilia Castillo",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botones y switches, como los tenías
            Button(
                onClick = { /* Acción para editar perfil */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFBB86FC))
            ) {
                Text("Editar Perfil")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Acción para restablecer contraseña */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF03DAC5))
            ) {
                Text("Restablecer Contraseña")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { notificacionesEnabled = !notificacionesEnabled }
            ) {
                Text(
                    text = "Notificaciones",
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = notificacionesEnabled,
                    onCheckedChange = { notificacionesEnabled = it },
                    colors = SwitchDefaults.colors(checkedThumbColor = Color(0xFFBB86FC))
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(
                onClick = { /* Acción para acceder a Favoritos */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Favoritos",
                    fontSize = 18.sp,
                    color = Color(0xFF03DAC5),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

// Ejemplos de las otras pantallas (puedes reemplazarlas con tus propias composables)
@Composable
fun Pantalla2() {
    Text(text = "Esta es la Pantalla 2")
}

@Composable
fun Pantalla3() {
    Text(text = "Esta es la Pantalla 3")
}

@Composable
fun Pantalla4() {
    Text(text = "Esta es la Pantalla 4")
}

@Preview(showBackground = true)
@Composable
fun PreviewPerfilScreen() {
    PerfilScreen()
}

