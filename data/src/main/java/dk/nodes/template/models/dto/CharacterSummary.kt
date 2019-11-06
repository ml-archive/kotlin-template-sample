package dk.nodes.template.models.dto

/**
 *
 * @param resourceURI The path to the individual character resource.
 * @param name The full name of the character.
 * @param role The role of the creator in the parent entity.
 */
data class CharacterSummary(
    /* The path to the individual character resource. */
    val resourceURI: String? = null,

    /* The full name of the character. */
    val name: String? = null,

    /* The role of the creator in the parent entity. */
    val role: String? = null
)
