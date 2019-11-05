package dk.nodes.template.models.dto

data class Data(
    val count: Int = 0,
    val limit: Int = 0,
    val offset: Int = 0,
    val results: List<Comic> = listOf(),
    val total: Int = 0
)