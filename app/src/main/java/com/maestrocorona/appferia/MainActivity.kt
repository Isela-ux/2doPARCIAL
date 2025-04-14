package com.maestrocorona.appferia

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen(onNavigateToSecondActivity = { naveName ->
                val intent = when (naveName) {
                    "Negocios de la Nave 1" -> Intent(this, Activity3::class.java)
                    "Negocios de la Nave 2" -> Intent(this, Activity4::class.java)
                    "Negocios de la Nave 3" -> Intent(this, Activity5::class.java)
                    "Fechas importantes" -> Intent(this, Activity2::class.java)
                    "Artistas" -> Intent(this, Activity6::class.java)
                    else -> return@MainScreen
                }
                startActivity(intent)
            })
        }
    }
}

@Composable
fun MainScreen(onNavigateToSecondActivity: (String) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo con imagen
        Image(
            painter = painterResource(id = R.drawable.fondo_logo),
            contentDescription = "Fondo decorativo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Contenido principal encima del fondo
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BusinessItem("Negocios de la Nave 1", onNavigateToSecondActivity)
            BusinessItem("Negocios de la Nave 2", onNavigateToSecondActivity)
            BusinessItem("Negocios de la Nave 3", onNavigateToSecondActivity)
            BusinessItem("Artistas", onNavigateToSecondActivity)

            Button(
                onClick = { onNavigateToSecondActivity("Fechas importantes") },
                modifier = Modifier.padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6650a4))
            ) {
                Text("Fechas importantes", fontFamily = FontFamily.SansSerif)
            }
        }
    }
}

@Composable
fun BusinessItem(text: String, onNavigateToSecondActivity: (String) -> Unit) {
    val purpleLight = Color(0xFF6650a4)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(145.dp)
            .clickable { onNavigateToSecondActivity(text) },
        colors = CardDefaults.cardColors(
            containerColor = purpleLight,
            contentColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_restt),
                contentDescription = "Logo restaurante",
                modifier = Modifier
                    .size(120.dp)
                    .padding(end = 16.dp)
            )
            Text(
                text = text,
                modifier = Modifier.padding(8.dp),
                fontFamily = FontFamily.SansSerif,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
