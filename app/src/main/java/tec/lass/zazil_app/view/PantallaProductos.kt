package tec.lass.zazil_app.view

import CategoriesRow
import ProductCard
import SearchBar
import SectionTitle
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import tec.lass.zazil_app.model.Producto
import tec.lass.zazil_app.model.productos




@Composable
fun PantallaProductos(
    categoriaSeleccionada: String?,
    textoBusqueda: String,
    navController: NavController,
    productosState: MutableList<Producto>,
    onSearch: (String) -> Unit = {},
    onCategorySelected: (String) -> Unit = {}
) {
    var textoBusquedaState by remember { mutableStateOf(textoBusqueda) }
    var categoriaSeleccionadaState by remember { mutableStateOf(categoriaSeleccionada) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        // Mostrar barra de búsqueda solo si no hay categoría seleccionada
        SearchBar(
            texto = textoBusquedaState,
            onSearch = { nuevoTexto ->
                textoBusquedaState = nuevoTexto
                onSearch(nuevoTexto)
            }
        )
        Spacer(modifier = Modifier.height(15.dp))

        CategoriesRow(
            categoriaSeleccionada = categoriaSeleccionadaState,
            onCategorySelected = { categoria ->
                if (categoriaSeleccionadaState == categoria) {
                    categoriaSeleccionadaState = null
                    onCategorySelected("")
                    navController.navigate("tienda") {
                        popUpTo("tienda") { inclusive = true }
                    }
                } else {
                    categoriaSeleccionadaState = categoria
                    onCategorySelected(categoria)
                }
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Filtrar productos por categoría o búsqueda
        val productosFiltrados = productosState.filter { producto ->
            (categoriaSeleccionadaState == null || producto.tipo == categoriaSeleccionadaState) ||
                    (textoBusquedaState.isNotEmpty() && producto.nombre.contains(
                        textoBusquedaState,
                        ignoreCase = true
                    ))
        }

        if (productosFiltrados.isEmpty()) {
            Text(
                text = "No se encontraron productos",
                color = Color.Red,
                modifier = Modifier.padding(16.dp)
            )
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(productosFiltrados) { producto ->
                    ProductCard(
                        producto = producto,
                        onFavoriteClick = {
                            val index = productosState.indexOf(producto)
                            if (index >= 0) {
                                productosState[index] = producto.copy(favorito = !producto.favorito)
                            }
                        },
                        onCarritoClick = {
                            val index = productosState.indexOf(producto)
                            if (index >= 0) {
                                productosState[index] = producto.copy(carrito = !producto.carrito)
                            }
                        }
                    )
                }
            }
        }
    }
}
