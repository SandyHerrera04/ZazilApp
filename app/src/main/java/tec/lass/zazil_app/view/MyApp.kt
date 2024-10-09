@file:OptIn(ExperimentalMaterial3Api::class)

package tec.lass.zazil_app.view

import PantallaTienda
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import kotlinx.coroutines.launch
import mx.sphr.zazil.viewmodel.LoginViewModel
import mx.sphr.zazil.viewmodel.SignUpViewModel
import tec.lass.zazil_app.model.Producto
import tec.lass.zazil_app.model.UserRepository
import tec.lass.zazil_app.model.integrantes
import tec.lass.zazil_app.model.productos
import tec.lass.zazil_app.viewmodel.PasswordRecoveryViewModel
import tec.lass.zazil_app.viewmodel.SessionViewModel
import tec.lass.zazil_app.viewmodel.UserProfileViewModel


/**
 * Composable MyApp
 *
 * Esta función define la estructura general de la aplicación utilizando Jetpack Compose.
 * Dependiendo de la ruta de navegación actual, decide si mostrar la pantalla de inicio de sesión o el menú lateral.
 *
 * @param navController Controlador de navegación utilizado para manejar las rutas entre pantallas.
 */

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyApp(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val backStackEntry = navController.currentBackStackEntryAsState().value
    val currentRoute = backStackEntry?.destination?.route // Obtener la ruta actual

    val productosState = remember { mutableStateListOf(*productos.toTypedArray()) }

    if (currentRoute == "login" || currentRoute == "signup") {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            content = { padding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                ) {
                    NavigationComponent(navController = navController, productosState = productosState)
                }
            }
        )
    } else {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                // Contenido del menú lateral
                ModalDrawerSheet {
                    DrawerHeader(
                        currentRoute = currentRoute,
                        onHeaderClick = {
                            if (currentRoute != "perfil"){
                                navController.navigate("perfil")
                            }
                        },
                        onCloseDrawer = {
                            scope.launch { drawerState.close() }
                        }
                    )

                    Spacer(modifier = Modifier.height(15.dp))
                    DrawerContent(navController = navController, onCloseDrawer = {
                        scope.launch { drawerState.close() }
                    })
                }
            },
            content = {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        val backStackEntry = navController.currentBackStackEntryAsState().value
                        val currentRoute = backStackEntry?.destination?.route
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    text = when (currentRoute) {
                                        "inicio" -> "INICIO"
                                        "tienda" -> "TIENDA"
                                        "productos/{categoriaSeleccionada}/{textoBusqueda}" -> "TIENDA"
                                        "calendario"-> "CALENDARIO"
                                        "hablemos" -> "HABLEMOS DE..."
                                        "perfil" -> "PERFIL"
                                        "carrito" -> "CARRITO"
                                        "conocenos"-> "CONÓCENOS"
                                        "aviso_priv"-> "AVISO DE PRIVACIDAD"
                                        "terminos_con"-> "TÉRMINOS Y CONDICIONES"
                                        "favoritos" -> "FAVORITOS"
                                        "creditos" -> "CRÉDITOS"
                                        "tema/{titulo}/{descripcion}/{imagen}/{infoCompleta}" -> "HABLEMOS DE..."
                                        "donaciones" -> "DONACIONES"
                                        else -> " "
                                    }
                                )
                            },
                            navigationIcon = {
                                IconButton(onClick = {
                                    scope.launch { drawerState.open() }
                                }) {
                                    Icon(
                                        Icons.Filled.Menu,
                                        contentDescription = "Abrir Menú",
                                        tint = Color.White
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                containerColor = Color(0xFFFDD5507C),
                                titleContentColor = Color.White
                            )
                        )
                    },
                    content = { padding ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding)
                        ) {
                            NavigationComponent(navController = navController, productosState = productosState)
                        }
                    }
                )
            }
        )
    }
}


/**
 * Composable NavigationComponent
 *
 * Esta función define la navegación entre las diferentes pantallas de la aplicación utilizando NavHost.
 *
 * @param navController Controlador de navegación utilizado para cambiar de pantalla.
 * @param productosState Lista mutable que contiene los productos de la tienda.
 */

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationComponent(navController: NavHostController, productosState: MutableList<Producto>) {
    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            LoginScreen(navController = navController, viewModel = LoginViewModel(), sessionViewModel = SessionViewModel())
        }
        composable("signup") {
            SignUpScreen(
                navController = navController,
                viewModel = SignUpViewModel(userRepository = UserRepository())
            )
        }

        composable("password_recovery") {
            PasswordRecoveryScreen(
                navController = navController,
                viewModel = PasswordRecoveryViewModel()
            )
        }
        composable("inicio") {
            PantallaInicio(navController = navController)
            //Column(
            // modifier = Modifier .fillMaxSize() .padding(16.dp)) {
            //Text("Este es el contenido principal de la app")

        }

        composable("tienda") {
            PantallaTienda(
                navController = navController,
                productosState = productosState
            ) // Pantalla de la tienda
        }
        composable("productos/{categoriaSeleccionada}/{textoBusqueda}") { backStackEntry ->
            val categoriaSeleccionada = backStackEntry.arguments?.getString("categoriaSeleccionada")
            val textoBusqueda = backStackEntry.arguments?.getString("textoBusqueda") ?: ""
            PantallaProductos(
                categoriaSeleccionada = categoriaSeleccionada,
                textoBusqueda = textoBusqueda,
                navController = navController,
                productosState = productosState
            ) // Pantalla de productos filtrados
        }
        composable(route = "perfil/{phone}") { backStackEntry ->
            val phone = backStackEntry.arguments?.getString("phone") ?: ""
            PantallaPerfil(navController, phone)

            composable("calendario") {
                PantallaCalendario() // Pantalla del calendario
            }
            composable("hablemos") {
                PantallaHablemosDe(navController = navController) // Pantalla de hablemos de
            }
            composable("conocenos") {
                PantallaConocenos() // Pantalla del carrito
            }
            composable("aviso_priv") {
                PantallaAvisoPriv() // Pantalla del carrito
            }
            composable("creditos") {
                PantallaCreditos(integrantes = integrantes)
            }
            composable("favoritos") {
                PantallaFavoritos(productosState.filter { it.favorito })
            }
            composable(
                "tema/{titulo}/{descripcion}/{imagen}/{infoCompleta}",
                arguments = listOf(
                    navArgument("titulo") { type = NavType.StringType },
                    navArgument("descripcion") { type = NavType.StringType },
                    navArgument("imagen") { type = NavType.IntType },
                    navArgument("infoCompleta") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                // Obtener los parámetros de la navegación
                val titulo = backStackEntry.arguments?.getString("titulo") ?: "Sin título"
                val descripcion =
                    backStackEntry.arguments?.getString("descripcion") ?: "Sin descripción"
                val imagen = backStackEntry.arguments?.getInt("imagen") ?: 0
                val infoCompleta = backStackEntry.arguments?.getString("infoCompleta")
                    ?: "Sin información completa"

                // Llamada a PantallaTema con los parámetros
                PantallaTema(
                    titulo = titulo,
                    descripcion = descripcion,
                    imagen = imagen,
                    infoCompleta = infoCompleta,
                    navController = navController
                )
            }
            composable("donaciones") {
                PantallaDonaciones() // Pantalla del carrito
            }
        }
    }
}


