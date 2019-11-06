package dk.nodes.template.models.dto

/**
 *
 * @param available The number of total available stories in this list. Will always be greater than or equal to the \"returned\" value.
 * @param returned The number of stories returned in this collection (up to 20).
 * @param collectionURI The path to the full list of stories in this collection.
 * @param items The list of returned stories in this collection.
 */
data class StoryList(
    /* The number of total available stories in this list. Will always be greater than or equal to the \"returned\" value. */
    val available: Int? = null,

    /* The number of stories returned in this collection (up to 20). */
    val returned: Int? = null,

    /* The path to the full list of stories in this collection. */
    val collectionURI: String? = null,

    /* The list of returned stories in this collection. */
    val items: List<Story>? = null
)
