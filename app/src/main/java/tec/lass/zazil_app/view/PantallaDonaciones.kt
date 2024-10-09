package tec.lass.zazil_app.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaDonaciones (){
    Column {
        Text(text = "¿Por qué donar?", fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text= "Cada día menstrúan en el mundo 800 millones de personas entre 15 y 49 años y, a pesar de ello, 500 millones de ellas no tienen acceso a productos menstruales y a instalaciones adecuadas para la salud menstrual. Así lo reportó en 2023 el Fondo de Naciones Unidas para la Población (Unfpa, por sus siglas en inglés).")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text="En México la situación no es mejor, el 15% de personas menstruantes no cuenta con los recursos para llevar una menstruación digna")
        Spacer(modifier = Modifier.height(10.dp))

    }


}