package dk.nodes.template.models.dto

/**
 *
 * @param resourceURI The path to the individual creator resource.
 * @param name The full name of the creator.
 * @param role The role of the creator in the parent entity.
 */
data class CreatorSummary(
    /* The path to the individual creator resource. */
    val resourceURI: String? = null,

    /* The full name of the creator. */
    val name: String? = null,

    /* The role of the creator in the parent entity. */
    val role: String? = null
)
