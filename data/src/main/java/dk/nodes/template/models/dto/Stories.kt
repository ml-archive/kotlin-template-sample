package dk.nodes.template.models.dto

data class Stories(
    val available: Int = 0,
    val collectionURI: String = "",
    val items: List<Item> = listOf(),
    val returned: Int = 0
)