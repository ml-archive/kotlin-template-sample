package dk.nodes.template.models.dto

/**
 *
 * @param resourceURI The path to the individual comic resource.
 * @param name The canonical name of the comic.
 */
data class ComicSummary(
    /* The path to the individual comic resource. */
    val resourceURI: String? = null,

    /* The canonical name of the comic. */
    val name: String? = null
)
