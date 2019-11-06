package dk.nodes.template.models.dto

/**
 *
 * @param resourceURI The path to the individual story resource.
 * @param name The canonical name of the story.
 * @param type The type of the story (interior or cover).
 */
data class StorySummary(
    /* The path to the individual story resource. */
    val resourceURI: String? = null,

    /* The canonical name of the story. */
    val name: String? = null,

    /* The type of the story (interior or cover). */
    val type: String? = null
)
