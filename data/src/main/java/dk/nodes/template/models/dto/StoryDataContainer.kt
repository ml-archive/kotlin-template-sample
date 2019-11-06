package dk.nodes.template.models.dto

/**
 *
 * @param offset The requested offset (number of skipped results) of the call.
 * @param limit The requested result limit.
 * @param total The total number of resources available given the current filter set.
 * @param count The total number of results returned by this call.
 * @param results The list of stories returned by the call
 */
data class StoryDataContainer(
    /* The requested offset (number of skipped results) of the call. */
    val offset: Int? = null,

    /* The requested result limit. */
    val limit: Int? = null,

    /* The total number of resources available given the current filter set. */
    val total: Int? = null,

    /* The total number of results returned by this call. */
    val count: Int? = null,

    /* The list of stories returned by the call */
    val results: StoryList? = null
)
