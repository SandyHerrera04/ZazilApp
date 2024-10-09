package tec.lass.zazil_app.model

data class Producto(
    val nombre: String,
    val precio: String,
    val imagenResId: Int,
    val tipo: String,  // Por ejemplo, "Nocturnas", "Teens", etc.
    val esNovedad: Boolean, // Si es o no un producto de nuevo
    val tieneDescuento : Boolean, //si tiene descuento o no
    val descripcion: String, // Descripción del producto
    var favorito: Boolean, // Si el producto es favorito o no
    var carrito: Boolean, // Si el producto está en el carrito o no
)
