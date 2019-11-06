package dk.nodes.template.models.dto

/**
 *
 * @param id The unique ID of the series resource.
 * @param title The canonical title of the series.
 * @param description A description of the series.
 * @param resourceURI The canonical URL identifier for this resource.
 * @param urls A set of public web site URLs for the resource.
 * @param startYear The first year of publication for the series.
 * @param endYear The last year of publication for the series (conventionally, 2099 for ongoing series) .
 * @param rating The age-appropriateness rating for the series.
 * @param modified The date the resource was most recently modified.
 * @param thumbnail The representative image for this series.
 * @param comics A resource list containing comics in this series.
 * @param stories A resource list containing stories which occur in comics in this series.
 * @param events A resource list containing events which take place in comics in this series.
 * @param characters A resource list containing characters which appear in comics in this series.
 * @param creators A resource list of creators whose work appears in comics in this series.
 * @param next A summary representation of the series which follows this series.
 * @param previous A summary representation of the series which preceded this series.
 */
data class Series(
    /* The unique ID of the series resource. */
    val id: Int? = null,

    /* The canonical title of the series. */
    val title: String? = null,

    /* A description of the series. */
    val description: String? = null,

    /* The canonical URL identifier for this resource. */
    val resourceURI: String? = null,

    /* A set of public web site URLs for the resource. */
    val urls: List<Url>? = null,

    /* The first year of publication for the series. */
    val startYear: Int? = null,

    /* The last year of publication for the series (conventionally, 2099 for ongoing series) . */
    val endYear: Int? = null,

    /* The age-appropriateness rating for the series. */
    val rating: String? = null,

    /* The date the resource was most recently modified. */
    val modified: String? = null,

    /* The representative image for this series. */
    val thumbnail: Image? = null,

    /* A resource list containing comics in this series. */
    val comics: ComicList? = null,

    /* A resource list containing stories which occur in comics in this series. */
    val stories: StoryList? = null,

    /* A resource list containing events which take place in comics in this series. */
    val events: EventList? = null,

    /* A resource list containing characters which appear in comics in this series. */
    val characters: CharacterList? = null,

    /* A resource list of creators whose work appears in comics in this series. */
    val creators: CreatorList? = null,

    /* A summary representation of the series which follows this series. */
    val next: SeriesSummary? = null,

    /* A summary representation of the series which preceded this series. */
    val previous: SeriesSummary? = null
)
