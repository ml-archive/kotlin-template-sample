package dk.nodes.template.models.dto

/**
 *
 * @param available The number of total available creators in this list. Will always be greater than or equal to the \"returned\" value.
 * @param returned The number of creators returned in this collection (up to 20).
 * @param collectionURI The path to the full list of creators in this collection.
 * @param items The list of returned creators in this collection.
 */
data class CreatorList(
    /* The number of total available creators in this list. Will always be greater than or equal to the \"returned\" value. */
    val available: Int? = null,

    /* The number of creators returned in this collection (up to 20). */
    val returned: Int? = null,

    /* The path to the full list of creators in this collection. */
    val collectionURI: String? = null,

    /* The list of returned creators in this collection. */
    val items: List<Creator>? = null
)
