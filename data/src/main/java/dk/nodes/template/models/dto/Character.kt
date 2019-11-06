package dk.nodes.template.models.dto

/**
 *
 * @param id The unique ID of the character resource.
 * @param name The name of the character.
 * @param description A short bio or description of the character.
 * @param modified The date the resource was most recently modified.
 * @param resourceURI The canonical URL identifier for this resource.
 * @param urls A set of public web site URLs for the resource.
 * @param thumbnail The representative image for this character.
 * @param comics A resource list containing comics which feature this character.
 * @param stories A resource list of stories in which this character appears.
 * @param events A resource list of events in which this character appears.
 * @param series A resource list of series in which this character appears.
 */
data class Character(
    /* The unique ID of the character resource. */
    val id: Int? = null,

    /* The name of the character. */
    val name: String? = null,

    /* A short bio or description of the character. */
    val description: String? = null,

    /* The date the resource was most recently modified. */
    val modified: String? = null,

    /* The canonical URL identifier for this resource. */
    val resourceURI: String? = null,

    /* A set of public web site URLs for the resource. */
    val urls: List<Url>? = null,

    /* The representative image for this character. */
    val thumbnail: Image? = null,

    /* A resource list containing comics which feature this character. */
    val comics: ComicList? = null,

    /* A resource list of stories in which this character appears. */
    val stories: StoryList? = null,

    /* A resource list of events in which this character appears. */
    val events: EventList? = null,

    /* A resource list of series in which this character appears. */
    val series: SeriesList? = null
)
