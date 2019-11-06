package dk.nodes.template.models.dto

/**
 *
 * @param id The unique ID of the event resource.
 * @param title The title of the event.
 * @param description A description of the event.
 * @param resourceURI The canonical URL identifier for this resource.
 * @param urls A set of public web site URLs for the event.
 * @param modified The date the resource was most recently modified.
 * @param start The date of publication of the first issue in this event.
 * @param end The date of publication of the last issue in this event.
 * @param thumbnail The representative image for this event.
 * @param comics A resource list containing the comics in this event.
 * @param stories A resource list containing the stories in this event.
 * @param series A resource list containing the series in this event.
 * @param characters A resource list containing the characters which appear in this event.
 * @param creators A resource list containing creators whose work appears in this event.
 * @param next A summary representation of the event which follows this event.
 * @param previous A summary representation of the event which preceded this event.
 */
data class Event(
    /* The unique ID of the event resource. */
    val id: Int? = null,

    /* The title of the event. */
    val title: String? = null,

    /* A description of the event. */
    val description: String? = null,

    /* The canonical URL identifier for this resource. */
    val resourceURI: String? = null,

    /* A set of public web site URLs for the event. */
    val urls: List<Url>? = null,

    /* The date the resource was most recently modified. */
    val modified: String? = null,

    /* The date of publication of the first issue in this event. */
    val start: String? = null,

    /* The date of publication of the last issue in this event. */
    val end: String? = null,

    /* The representative image for this event. */
    val thumbnail: Image? = null,

    /* A resource list containing the comics in this event. */
    val comics: ComicList? = null,

    /* A resource list containing the stories in this event. */
    val stories: StoryList? = null,

    /* A resource list containing the series in this event. */
    val series: SeriesList? = null,

    /* A resource list containing the characters which appear in this event. */
    val characters: CharacterList? = null,

    /* A resource list containing creators whose work appears in this event. */
    val creators: CreatorList? = null,

    /* A summary representation of the event which follows this event. */
    val next: EventSummary? = null,

    /* A summary representation of the event which preceded this event. */
    val previous: EventSummary? = null
)
