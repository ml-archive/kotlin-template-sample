package dk.nodes.template.models.dto

/**
 *
 * @param available The number of total available events in this list. Will always be greater than or equal to the \"returned\" value.
 * @param returned The number of events returned in this collection (up to 20).
 * @param collectionURI The path to the full list of events in this collection.
 * @param items The list of returned events in this collection.
 */
data class EventList(
    /* The number of total available events in this list. Will always be greater than or equal to the \"returned\" value. */
    val available: Int? = null,

    /* The number of events returned in this collection (up to 20). */
    val returned: Int? = null,

    /* The path to the full list of events in this collection. */
    val collectionURI: String? = null,

    /* The list of returned events in this collection. */
    val items: List<Event>? = null
)
