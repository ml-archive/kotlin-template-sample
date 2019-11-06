package dk.nodes.template.models.dto

/**
 *
 * @param type A text identifier for the URL.
 * @param url A full URL (including scheme, domain, and path).
 */
data class Url(
    /* A text identifier for the URL. */
    val type: String? = null,

    /* A full URL (including scheme, domain, and path). */
    val url: String? = null
)
