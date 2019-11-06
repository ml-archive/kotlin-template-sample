package dk.nodes.template.models.dto

/**
 *
 * @param type A description of the date (e.g. onsale date, FOC date).
 * @param date The date.
 */
data class ComicDate(
    /* A description of the date (e.g. onsale date, FOC date). */
    val type: String? = null,

    /* The date. */
    val date: String? = null
)
