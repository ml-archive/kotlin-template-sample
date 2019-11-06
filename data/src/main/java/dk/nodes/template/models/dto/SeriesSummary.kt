package dk.nodes.template.models.dto

/**
 *
 * @param resourceURI The path to the individual series resource.
 * @param name The canonical name of the series.
 */
data class SeriesSummary(
    /* The path to the individual series resource. */
    val resourceURI: String? = null,

    /* The canonical name of the series. */
    val name: String? = null
)
