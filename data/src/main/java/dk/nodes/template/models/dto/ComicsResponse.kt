package dk.nodes.template.models.dto

data class ComicsResponse(
    val attributionHTML: String = "",
    val attributionText: String = "",
    val code: Int = 0,
    val copyright: String = "",
    val `data`: Data = Data(),
    val etag: String = "",
    val status: String = ""
)