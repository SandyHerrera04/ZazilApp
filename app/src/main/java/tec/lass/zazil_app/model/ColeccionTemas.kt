package tec.lass.zazil_app.model

import tec.lass.zazil_app.R
val temas = listOf(
    Tema ("Introducción a la menstruación", R.drawable.ic_launcher_foreground, "Te explicamos qué onda con la menstruación", "La menstruación", Zazil = false, Menst = true, Dato = false),
    Tema ("Lavando mi toalla ZAZIL", R.drawable.lavar, "Te explicamos cómo lavar tu toalla ZAZIL", "Lavando tuxee", Zazil = true, Menst = false, Dato = false), // ZAZIL
    Tema ("Datos sobre el uso de toallas desechables", R.drawable.ic_carrito, "Uso de aprox 4800 tampones durante la vida fértil", "Tampones", Zazil = false, Menst = false, Dato = true), // DATOS
    Tema ("Pobreza menstrual", R.drawable.ic_launcher_foreground, "La condición en la que vive más de 10 millones de personas menstruantes", "La menstruación", Zazil = false, Menst = true, Dato = false), // La menstruación
    Tema ("Proceso de fabricación", R.drawable.ic_noticias, "Conoce lo que hay detrás de tu toalla ZAZIL", "Proceso de fabricación de las toallas zazil en México", Zazil = true, Menst = false, Dato = false), // ZAZIL
    Tema ("La menopausia", R.drawable.ic_launcher_foreground, "Te explicamos qué es la menopausia", "La menopausia", Zazil = false, Menst = true, Dato = false), // La menstruación
    Tema ("Características del ciclo menstrual", R.drawable.ic_launcher_foreground, "Conoce las características del ciclo menstrual", "Ciclo menstrual", Zazil = false, Menst = true, Dato = false), // La menstruación
    Tema ("Síndrome premenstrual", R.drawable.ic_launcher_foreground, "Te explicamos qué es el síndrome premenstrual", "Síndrome premenstrual", Zazil = false, Menst = true, Dato = false), // La menstruación
    Tema ("Metales pesados en tampones", R.drawable.ic_launcher_foreground, "Te explicamos qué son los metales pesados en tampones", "Metales pesados",  Zazil = false, Menst = false, Dato = true), // DATOS
    Tema ("Licencia menstrual", R.drawable.ic_launcher_foreground, "Te explicamos qué es la licencia menstrual", "Licencia menstrual",  Zazil = false, Menst = false, Dato = true), // DATOS
    Tema ("Mi primera menstruación", R.drawable.ic_launcher_foreground, "Cómo saber si es tu primera menstruación", "Primera menstruación",  Zazil = false, Menst = true, Dato = false) // La menstruación
)