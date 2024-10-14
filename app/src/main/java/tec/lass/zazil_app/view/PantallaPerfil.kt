package tec.lass.zazil_app.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import tec.lass.zazil_app.viewmodel.UserProfileViewModel

@Composable
fun PantallaPerfil(viewModel: UserProfileViewModel, phone: String) {
    // Lanzamos la función de carga de datos cuando la pantalla es visible
    Log.d("PantallaPerfil", "Valor de phone: $phone")

    LaunchedEffect(Unit) {
        viewModel.loadUserData(phone)
        Log.d("PantallaPerfil", "Cargando los datos del usuario para $phone")
    }

    val userData by viewModel.userData.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        userData?.let { user ->
            // Mostrar el nombre del usuario
            Text(
                text = user.name ?: "Nombre no disponible",
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Mostrar el correo del usuario
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Email, contentDescription = "Correo")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = user.email ?: "Correo no disponible")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Mostrar el teléfono del usuario
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Phone, contentDescription = "Teléfono")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = user.phone ?: "Teléfono no disponible")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Mostrar la ubicación del usuario
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Place, contentDescription = "Ubicación")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = user.location ?: "Ubicación no disponible")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Mostrar la fecha de nacimiento del usuario
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.DateRange, contentDescription = "Fecha de nacimiento")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = user.birthdate ?: "Fecha de nacimiento no disponible")
            }
        } ?: run {
            // Mensaje de error si no se encuentran los datos del usuario
            Text(text = "No se encontraron datos del usuario", color = Color.Red)
        }
    }
}
