package dk.nodes.template.models.dto

/**
 *
 * @param resourceURI The path to the individual event resource.
 * @param name The name of the event.
 */
data class EventSummary(
    /* The path to the individual event resource. */
    val resourceURI: String? = null,

    /* The name of the event. */
    val name: String? = null
)
