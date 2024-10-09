package tec.lass.zazil_app.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tec.lass.zazil_app.R

@Composable
fun DrawerHeader( currentRoute: String?, onHeaderClick: () -> Unit, onCloseDrawer: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFDD5507C)) // Color con opacidad
            .clickable {
                if (currentRoute != "perfil") {
                    onHeaderClick()
                    onCloseDrawer()
                }
            }
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_usuario),
            contentDescription = "Usuario",
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Usuario",
            color = Color.Black,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}


