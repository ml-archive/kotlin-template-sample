package dk.nodes.template.models.dto

data class Events(
    val available: Int = 0,
    val collectionURI: String = "",
    val items: List<Any> = listOf(),
    val returned: Int = 0
)