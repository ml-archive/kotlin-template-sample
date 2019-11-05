package dk.nodes.template.models.dto

data class Item(
    val name: String = "",
    val resourceURI: String = "",
    val type: String? = null,
    val role: String? = null
)