package tec.lass.zazil_app.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import tec.lass.zazil_app.R
@Composable
fun DrawerContent(navController: NavController, onCloseDrawer: () -> Unit) {
    Column(modifier = Modifier.padding(6.dp)) {
        MenuOption(iconResId = R.drawable.ic_inicio, label = "Inicio") {
            // Acción al hacer clic en "Inicio"
            navController.navigate("inicio")
            onCloseDrawer()
        }
        //Spacer(modifier = Modifier.height(6.dp))
        //MenuOption(iconResId = R.drawable.ic_usuario, label = "Perfil") {
            // Acción al hacer clic en "Perfil"
        //}
        Spacer(modifier = Modifier.height(6.dp))
        MenuOption(iconResId = R.drawable.ic_tienda, label = "Tienda") {
            navController.navigate("tienda")
            onCloseDrawer()
        }
        Spacer(modifier = Modifier.height(6.dp))
        MenuOption(iconResId = R.drawable.ic_calendario, label = "Calendario") {
            navController.navigate("calendario")
            onCloseDrawer()
        }
        Spacer(modifier = Modifier.height(6.dp))
        MenuOption(iconResId = R.drawable.ic_hablemos, label = "Hablemos de...") {
            navController.navigate("hablemos")
            onCloseDrawer()
        }
        Spacer(modifier = Modifier.height(6.dp))
        MenuOption(iconResId = R.drawable.ic_carrito, label = "Carrito") {
            //navController.navigate("carrito")
        }
        Spacer(modifier = Modifier.height(6.dp))
        MenuOption(iconResId = R.drawable.ic_favoritos, label = "Favoritos") {
            navController.navigate("favoritos")
            onCloseDrawer()

        }
        Spacer(modifier = Modifier.height(6.dp))
        MenuOption(iconResId = R.drawable.ic_conocenos, label = "Conócenos") {
            navController.navigate("conocenos")
            onCloseDrawer()
        }
        Spacer(modifier = Modifier.height(6.dp))
        MenuOption(iconResId = R.drawable.ic_donar, label = "Donar") {
            navController.navigate("donaciones")
            onCloseDrawer()
        }
        Spacer(modifier = Modifier.height(6.dp))
        MenuOption(iconResId = R.drawable.ic_aviso, label = "Aviso de privacidad") {
            navController.navigate("aviso_priv")
            onCloseDrawer()

        }
        Spacer(modifier = Modifier.height(6.dp))
        MenuOption(iconResId = R.drawable.ic_creditos, label = "Créditos") {
            navController.navigate("creditos")
            onCloseDrawer()
        }

    }
}

