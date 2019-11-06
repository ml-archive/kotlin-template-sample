package dk.nodes.template.models.dto

/**
 *
 * @param type The canonical type of the text object (e.g. solicit text, preview text, etc.).
 * @param language The IETF language tag denoting the language the text object is written in.
 * @param text The text.
 */
data class TextObject(
    /* The canonical type of the text object (e.g. solicit text, preview text, etc.). */
    val type: String? = null,

    /* The IETF language tag denoting the language the text object is written in. */
    val language: String? = null,

    /* The text. */
    val text: String? = null
)
