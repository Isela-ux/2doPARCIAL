package com.maestrocorona.appferia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Activity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nave2Screen()
        }
    }
}

@Composable
fun Nave2Screen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Título centrado
        Text(
            text = "Platillos Tipicos",
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp, start = 16.dp, end = 16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Imagen sin borde, con esquinas redondeadas abajo
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Imagen de la Nave 2",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Texto informativo
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = """
                    En la Nave 2, descubrirás los sabores auténticos y tradicionales de nuestra región. 
                    Aquí encontrarás una increíble selección de platillos típicos, desde los más emblemáticos 
                    hasta las innovaciones culinarias que reflejan nuestra cultura.
                    
                """.trimIndent(),
                fontSize = 16.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Justify
            )

            Text(
                text = "¡Ven y vive la experiencia de la cultura tabasqueña!",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Nave2ScreenPreview() {
    Nave2Screen()
}
