import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import tec.lass.zazil_app.R
import tec.lass.zazil_app.model.Producto
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import tec.lass.zazil_app.model.productos
import tec.lass.zazil_app.view.PantallaProductos


@Composable
fun PantallaTienda(navController: NavHostController, productosState: MutableList<Producto>) {
    var textoBusqueda by remember { mutableStateOf("") }
    var categoriaSeleccionada by remember { mutableStateOf<String?>(null) }

    //val productosState = remember { mutableStateListOf(*productos.toTypedArray()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(rememberScrollState())  // Agrega el scroll vertical
    ) {

        // Mostrar barra de búsqueda solo si no hay categoría seleccionada
        SearchBar(
            texto = textoBusqueda,
            onSearch = { nuevoTexto ->
                textoBusqueda = nuevoTexto
                navController.navigate("productos/${categoriaSeleccionada ?: "null"}/$nuevoTexto")
            }
        )
        Spacer(modifier = Modifier.height(15.dp))

        // Categorías
        CategoriesRow(
            categoriaSeleccionada = categoriaSeleccionada,
            onCategorySelected = { categoria ->
                if (categoriaSeleccionada == categoria) {
                    categoriaSeleccionada = null
                    navController.popBackStack()  // Vuelve a la tienda sin filtros
                } else {
                    categoriaSeleccionada = categoria
                    navController.navigate("productos/$categoria/$textoBusqueda")
                }
            }
        )

        // Sección de descuentos
        Spacer(modifier = Modifier.height(20.dp))
        SectionTitle(title = "Descuentos")
        Spacer(modifier = Modifier.height(8.dp))
        ProductRow(
            productos = productos.filter { it.tieneDescuento },
            onFavoriteClick = { producto ->
                val index = productosState.indexOf(producto)
                if (index >= 0) {
                    productosState[index] = producto.copy(favorito = !producto.favorito)
                }
            },
            onCarritoClick = { producto ->
                val index = productosState.indexOf(producto)
                if (index >= 0) {
                    productosState[index] = producto.copy(carrito = !producto.carrito)
                }
                // Acción cuando se hace clic en el icono de carrito
            }
        )

        // Sección de novedades
        Spacer(modifier = Modifier.height(26.dp))
        SectionTitle(title = "Novedades")
        Spacer(modifier = Modifier.height(8.dp))
        ProductRow(
            productos = productos.filter { it.esNovedad },
            onFavoriteClick = { producto ->
                val index = productosState.indexOf(producto)
                if (index >= 0) {
                    productosState[index] = producto.copy(favorito = !producto.favorito)
                }
            },
            onCarritoClick = { producto ->
                val index = productosState.indexOf(producto)
                if (index >= 0) {
                    productosState[index] = producto.copy(carrito = !producto.carrito)
                }
            }
        )

        ProductRow(
            productos = productos.filter { it.tipo == "Nocturnas" },
            onFavoriteClick = { producto ->
                val index = productosState.indexOf(producto)
                if (index >= 0) {
                    productosState[index] = producto.copy(favorito = !producto.favorito)
                }
            },
            onCarritoClick = { producto ->
                val index = productosState.indexOf(producto)
                if (index >= 0) {
                    productosState[index] = producto.copy(carrito = !producto.carrito)
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        ProductRow(
            productos = productos.filter { it.tipo == "Teens" },
            onFavoriteClick = { producto ->
                val index = productosState.indexOf(producto)
                if (index >= 0) {
                    productosState[index] = producto.copy(favorito = !producto.favorito)
                }
            },
            onCarritoClick = { producto ->
                val index = productosState.indexOf(producto)
                if (index >= 0) {
                    productosState[index] = producto.copy(carrito = !producto.carrito)
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        ProductRow(
            productos = productos.filter { it.tipo == "Regulares" },
            onFavoriteClick = { producto ->
                val index = productosState.indexOf(producto)
                if (index >= 0) {
                    productosState[index] = producto.copy(favorito = !producto.favorito)
                }
            },
            onCarritoClick = { producto ->
                val index = productosState.indexOf(producto)
                if (index >= 0) {
                    productosState[index] = producto.copy(carrito = !producto.carrito)
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        ProductRow(
            productos = productos.filter { it.tipo == "Kits" },
            onFavoriteClick = { producto ->
                val index = productosState.indexOf(producto)
                if (index >= 0) {
                    productosState[index] = producto.copy(favorito = !producto.favorito)
                }
            },
            onCarritoClick = { producto ->
                val index = productosState.indexOf(producto)
                if (index >= 0) {
                    productosState[index] = producto.copy(carrito = !producto.carrito)
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        ProductRow(
            productos = productos.filter { it.tipo == "Protectores" },
            onFavoriteClick = { producto ->
                val index = productosState.indexOf(producto)
                if (index >= 0) {
                    productosState[index] = producto.copy(favorito = !producto.favorito)
                }
            },
            onCarritoClick = { producto ->
                val index = productosState.indexOf(producto)
                if (index >= 0) {
                    productosState[index] = producto.copy(carrito = !producto.carrito)
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}


@Composable
fun SearchBar(texto : String, onSearch: (String) -> Unit) {
    var textoBusqueda by remember { mutableStateOf (texto) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray, RoundedCornerShape(24.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_buscar), contentDescription = "Buscar", tint = Color.Gray)
        Spacer(modifier = Modifier.width(8.dp))
        BasicTextField(
            value = textoBusqueda,
            onValueChange = {
                textoBusqueda = it
                onSearch(textoBusqueda) // Llama a la función de búsqueda cuando cambia el texto
            },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = 16.sp, color = Color.Gray)
        )
        Icon(painter = painterResource(id = R.drawable.ic_filtro), contentDescription = "Filtrar", tint = Color.Black)
    }
}

fun spacer(modifier: Modifier) {

}

@Composable
fun CategoriesRow(
    categoriaSeleccionada: String?,
    onCategorySelected: (String) -> Unit
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        CategoryItem(
            label = "Nocturnas",
            imageRes = R.drawable.nocturne,
            isSelected = categoriaSeleccionada == "Nocturnas",
            onClick = { onCategorySelected("Nocturnas") })
        CategoryItem(
            label = "Teens",
            imageRes = R.drawable.teen,
            isSelected = categoriaSeleccionada == "Teens",
            onClick = { onCategorySelected("Teens") })
        CategoryItem(
            label = "Regulares",
            imageRes = R.drawable.regular,
            isSelected = categoriaSeleccionada == "Regulares",
            onClick = { onCategorySelected("Regulares") })
        CategoryItem(
            label = "Kits",
            imageRes = R.drawable.kit,
            isSelected = categoriaSeleccionada == "Kits",
            onClick = { onCategorySelected("Kits") })
        CategoryItem(
            label = "Protectores",
            imageRes = R.drawable.protector,
            isSelected = categoriaSeleccionada == "Protectores",
            onClick = { onCategorySelected("Protectores") })
    }
}

@Composable
fun CategoryItem(label: String, imageRes: Int, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) Color(0xFF95E3EB) else Color(0xFFF2CAD5)
    val borderColor = if (isSelected) Color(0xFFE91E63) else Color(0xFFE91E63)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onClick()}
            .background(backgroundColor, shape = RoundedCornerShape(12.dp))
            .border(1.dp, borderColor, shape = RoundedCornerShape(12.dp))
            .padding(8.dp)) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = label,
            modifier = Modifier.size(48.dp), // Ajustar el tamaño de la imagen
            contentScale = ContentScale.Crop // Ajustar la escala de la imagen
        )
        Text(text = label, fontSize = 12.sp, color = Color(0xFFE91E63))
    }
}

@Composable
fun SectionTitle(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE91E63), RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = title, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun ProductRow(
    productos: List<Producto>,
    onFavoriteClick: (Producto) -> Unit,
    onCarritoClick: (Producto) -> Unit) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(productos) { producto ->
            ProductCard(
                producto=producto,
                onFavoriteClick = onFavoriteClick,
                onCarritoClick = onCarritoClick
            )
        }
    }
}

@Composable
fun ProductCard(
    producto: Producto,
    onFavoriteClick: (Producto) -> Unit,
    onCarritoClick: (Producto) -> Unit
) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .padding(8.dp)
            .height(250.dp),  // Establecer una altura fija para todas las tarjetas
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = producto.imagenResId),
                contentDescription = producto.nombre,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = producto.nombre, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = producto.precio, fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {
                    onFavoriteClick(producto)
                }) {
                    Icon(
                        painter = painterResource(
                            id = if (producto.favorito) R.drawable.ic_favorito_lleno else R.drawable.ic_favorito_vacio
                        ),
                        contentDescription = "Favorito",
                        tint = if (producto.favorito) Color.Red else Color.Gray
                    )
                }
                IconButton(onClick = {
                    onCarritoClick(producto)
                }) {
                    Icon(
                        painter = painterResource(
                            id = if (producto.carrito) R.drawable.ic_carrito_lleno else R.drawable.ic_carrito_vacio
                        ),
                        contentDescription = "Carrito",
                        tint = if (producto.carrito) Color.Magenta else Color.Gray
                    )
                }
            }
        }
    }
}
