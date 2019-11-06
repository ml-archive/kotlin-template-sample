package dk.nodes.template.models.dto

/**
 *
 * @param type A description of the price (e.g. print price, digital price).
 * @param price The price (all prices in USD).
 */
data class ComicPrice(
    /* A description of the price (e.g. print price, digital price). */
    val type: String? = null,

    /* The price (all prices in USD). */
    val price: Float? = null
)
