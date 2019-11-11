package dk.nodes.template.models.dto

/**
 *
 * @param id The unique ID of the creator resource.
 * @param firstName The first name of the creator.
 * @param middleName The middle name of the creator.
 * @param lastName The last name of the creator.
 * @param suffix The suffix or honorific for the creator.
 * @param fullName The full name of the creator (a space-separated concatenation of the above four fields).
 * @param modified The date the resource was most recently modified.
 * @param resourceURI The canonical URL identifier for this resource.
 * @param urls A set of public web site URLs for the resource.
 * @param thumbnail The representative image for this creator.
 * @param series A resource list containing the series which feature work by this creator.
 * @param stories A resource list containing the stories which feature work by this creator.
 * @param comics A resource list containing the comics which feature work by this creator.
 * @param events A resource list containing the events which feature work by this creator.
 */
data class Creator(
    /* The unique ID of the creator resource. */
    val id: Int? = null,

    /* The first name of the creator. */
    val firstName: String? = null,

    /* The middle name of the creator. */
    val middleName: String? = null,

    /* The last name of the creator. */
    val lastName: String? = null,

    val name: String? = null,

    /* The suffix or honorific for the creator. */
    val suffix: String? = null,

    /* The full name of the creator (a space-separated concatenation of the above four fields). */
    val fullName: String? = null,

    /* The date the resource was most recently modified. */
    val modified: String? = null,

    /* The canonical URL identifier for this resource. */
    val resourceURI: String? = null,

    /* A set of public web site URLs for the resource. */
    val urls: List<Url>? = null,

    /* The representative image for this creator. */
    val thumbnail: Image? = null,

    /* A resource list containing the series which feature work by this creator. */
    val series: SeriesList? = null,

    /* A resource list containing the stories which feature work by this creator. */
    val stories: StoryList? = null,

    /* A resource list containing the comics which feature work by this creator. */
    val comics: ComicList? = null,

    /* A resource list containing the events which feature work by this creator. */
    val events: EventList? = null,

    val role: String? = null
)
