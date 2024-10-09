package tec.lass.zazil_app.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import tec.lass.zazil_app.R
import tec.lass.zazil_app.viewmodel.UserProfileViewModel

@Composable
fun PantallaPerfil(navController: NavController, phone: String) {
    // Crear una instancia del ViewModel usando remember
    val viewModel = remember { UserProfileViewModel() }

    LaunchedEffect(Unit) {
        viewModel.loadUserData(phone)
    }

    val userData by viewModel.userData.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC0CB)) // Fondo rosado
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen de perfil superior
        Image(
            painter = painterResource(id = R.drawable.ic_usuario), // Asegúrate de tener una imagen de perfil predeterminada
            contentDescription = "Imagen de perfil",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            shape = RoundedCornerShape(8.dp),
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                // Mostrar los datos del usuario
                userData?.let { user ->
                    Text(
                        text = user.name ?: "Nombre no disponible",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF880E4F)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    // Correo electrónico
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Email, contentDescription = "Correo", tint = Color.Gray)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = user.email ?: "Correo no disponible")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Teléfono
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Phone, contentDescription = "Teléfono", tint = Color.Gray)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = user.phone ?: "Teléfono no disponible")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Ubicación
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Place, contentDescription = "Ubicación", tint = Color.Gray)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = user.location ?: "Ubicación no disponible")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Fecha de nacimiento
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.DateRange, contentDescription = "Fecha de nacimiento", tint = Color.Gray)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = user.birthdate ?: "Fecha de nacimiento no disponible")
                    }
                } ?: run {
                    Text(text = "No se encontraron datos del usuario", color = Color.Red)
                }
            }
        }
    }
}