package dk.nodes.template.models.dto

/**
 *
 * @param path The directory path of to the image.
 * @param extension The file extension for the image.
 */
data class Image(
    /* The directory path of to the image. */
    val path: String? = null,

    /* The file extension for the image. */
    val extension: String? = null
)
