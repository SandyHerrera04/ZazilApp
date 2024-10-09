package tec.lass.zazil_app.model


data class User(
    val name: String? = null,
    val email: String? = null,
    val phone: String? = null,  // Aquí es donde se guarda el número de teléfono
    val curp: String? = null,
    val birthdate: String? = null,
    val location: String? = null
)




