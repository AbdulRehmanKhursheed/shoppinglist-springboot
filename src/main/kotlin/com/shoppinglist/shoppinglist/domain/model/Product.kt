data class Product(
    val id: String,
    val name: String,
    val category: String,
    val price: Double? = null,
    val unit: String? = null, // kg, piece, liter, etc.
    val brand: String? = null,
    val description: String? = null
)