package dk.nodes.template.models.dto

/**
 *
 * @param available The number of total available issues in this list. Will always be greater than or equal to the \"returned\" value.
 * @param returned The number of issues returned in this collection (up to 20).
 * @param collectionURI The path to the full list of issues in this collection.
 * @param items The list of returned issues in this collection.
 */
data class ComicList(
    /* The number of total available issues in this list. Will always be greater than or equal to the \"returned\" value. */
    val available: Int? = null,

    /* The number of issues returned in this collection (up to 20). */
    val returned: Int? = null,

    /* The path to the full list of issues in this collection. */
    val collectionURI: String? = null,

    /* The list of returned issues in this collection. */
    val items: List<Comic>? = null
)
