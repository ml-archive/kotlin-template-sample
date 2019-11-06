package dk.nodes.template.models.dto

/**
 *
 * @param id The unique ID of the comic resource.
 * @param digitalId The ID of the digital comic representation of this comic. Will be 0 if the comic is not available digitally.
 * @param title The canonical title of the comic.
 * @param issueNumber The number of the issue in the series (will generally be 0 for collection formats).
 * @param variantDescription If the issue is a variant (e.g. an alternate cover, second printing, or director’s cut), a text description of the variant.
 * @param description The preferred description of the comic.
 * @param modified The date the resource was most recently modified.
 * @param isbn The ISBN for the comic (generally only populated for collection formats).
 * @param upc The UPC barcode number for the comic (generally only populated for periodical formats).
 * @param diamondCode The Diamond code for the comic.
 * @param ean The EAN barcode for the comic.
 * @param issn The ISSN barcode for the comic.
 * @param format The publication format of the comic e.g. comic, hardcover, trade paperback.
 * @param pageCount The number of story pages in the comic.
 * @param textObjects A set of descriptive text blurbs for the comic.
 * @param resourceURI The canonical URL identifier for this resource.
 * @param urls A set of public web site URLs for the resource.
 * @param series A summary representation of the series to which this comic belongs.
 * @param variants A list of variant issues for this comic (includes the \"original\" issue if the current issue is a variant).
 * @param collections A list of collections which include this comic (will generally be empty if the comic's format is a collection).
 * @param collectedIssues A list of issues collected in this comic (will generally be empty for periodical formats such as \"comic\" or \"magazine\").
 * @param dates A list of key dates for this comic.
 * @param prices A list of prices for this comic.
 * @param thumbnail The representative image for this comic.
 * @param images A list of promotional images associated with this comic.
 * @param creators A resource list containing the creators associated with this comic.
 * @param characters A resource list containing the characters which appear in this comic.
 * @param stories A resource list containing the stories which appear in this comic.
 * @param events A resource list containing the events in which this comic appears.
 */
data class Comic(
    /* The unique ID of the comic resource. */
    val id: Int? = null,

    /* The ID of the digital comic representation of this comic. Will be 0 if the comic is not available digitally. */
    val digitalId: Int? = null,

    /* The canonical title of the comic. */
    val title: String? = null,

    /* The number of the issue in the series (will generally be 0 for collection formats). */
    val issueNumber: Double? = null,

    /* If the issue is a variant (e.g. an alternate cover, second printing, or director’s cut), a text description of the variant. */
    val variantDescription: String? = null,

    /* The preferred description of the comic. */
    val description: String? = null,

    /* The date the resource was most recently modified. */
    val modified: String? = null,

    /* The ISBN for the comic (generally only populated for collection formats). */
    val isbn: String? = null,

    /* The UPC barcode number for the comic (generally only populated for periodical formats). */
    val upc: String? = null,

    /* The Diamond code for the comic. */
    val diamondCode: String? = null,

    /* The EAN barcode for the comic. */
    val ean: String? = null,

    /* The ISSN barcode for the comic. */
    val issn: String? = null,

    /* The publication format of the comic e.g. comic, hardcover, trade paperback. */
    val format: String? = null,

    /* The number of story pages in the comic. */
    val pageCount: Int? = null,

    /* A set of descriptive text blurbs for the comic. */
    val textObjects: List<TextObject>? = null,

    /* The canonical URL identifier for this resource. */
    val resourceURI: String? = null,

    /* A set of public web site URLs for the resource. */
    val urls: List<Url>? = null,

    /* A summary representation of the series to which this comic belongs. */
    val series: SeriesSummary? = null,

    /* A list of variant issues for this comic (includes the \"original\" issue if the current issue is a variant). */
    val variants: List<Any>? = null,

    /* A list of collections which include this comic (will generally be empty if the comic's format is a collection). */
    val collections: List<Any>? = null,

    /* A list of issues collected in this comic (will generally be empty for periodical formats such as \"comic\" or \"magazine\"). */
    val collectedIssues: List<Any>? = null,

    /* A list of key dates for this comic. */
    val dates: List<String>? = null,

    /* A list of prices for this comic. */
    val prices: List<ComicPrice>? = null,

    /* The representative image for this comic. */
    val thumbnail: Image? = null,

    /* A list of promotional images associated with this comic. */
    val images: List<Image>? = null,

    /* A resource list containing the creators associated with this comic. */
    val creators: CreatorList? = null,

    /* A resource list containing the characters which appear in this comic. */
    val characters: CharacterList? = null,

    /* A resource list containing the stories which appear in this comic. */
    val stories: StoryList? = null,

    /* A resource list containing the events in which this comic appears. */
    val events: EventList? = null
)
