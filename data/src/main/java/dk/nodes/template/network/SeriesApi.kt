package dk.nodes.template.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SeriesApi {
    /**
     * Fetches lists of characters filtered by a series id.
     * Fetches lists of characters which appear in specific series, with optional filters. See notes on individual parameters below.
     * @param seriesId The series id. (required)
     * @param name Return only characters matching the specified full character name (e.g. Spider-Man). (optional)
     * @param nameStartsWith Return characters with names that begin with the specified string (e.g. Sp). (optional)
     * @param modifiedSince Return only characters which have been modified since the specified date. (optional)
     * @param comics Return only characters which appear in the specified comics (accepts a comma-separated list of ids). (optional)
     * @param events Return only characters which appear comics that took place in the specified events (accepts a comma-separated list of ids). (optional)
     * @param stories Return only characters which appear the specified stories (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("series/{seriesId}/characters")
    suspend fun getSeriesCharacterWrapper(
        @Path("seriesId") seriesId: Int,
        @Query("name") name: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("comics") comics: Array<Int>? = null,
        @Query("events") events: Array<Int>? = null,
        @Query("stories") stories: Array<Int>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>

    /**
     * Fetches lists of series.
     * Fetches lists of comic series with optional filters. See notes on individual parameters below.
     * @param title Return only series matching the specified title. (optional)
     * @param titleStartsWith Return series with titles that begin with the specified string (e.g. Sp). (optional)
     * @param startYear Return only series matching the specified start year. (optional)
     * @param modifiedSince Return only series which have been modified since the specified date. (optional)
     * @param comics Return only series which contain the specified comics (accepts a comma-separated list of ids). (optional)
     * @param stories Return only series which contain the specified stories (accepts a comma-separated list of ids). (optional)
     * @param events Return only series which have comics that take place during the specified events (accepts a comma-separated list of ids). (optional)
     * @param creators Return only series which feature work by the specified creators (accepts a comma-separated list of ids). (optional)
     * @param characters Return only series which feature the specified characters (accepts a comma-separated list of ids). (optional)
     * @param seriesType Filter the series by publication frequency type. (optional)
     * @param contains Return only series containing one or more comics with the specified format. (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("series")
    suspend fun getSeriesCollection(
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("comics") comics: Array<Int>? = null,
        @Query("stories") stories: Array<Int>? = null,
        @Query("events") events: Array<Int>? = null,
        @Query("creators") creators: Array<Int>? = null,
        @Query("characters") characters: Array<Int>? = null,
        @Query("seriesType") seriesType: String? = null,
        @Query("contains") contains: Array<String>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>

    /**
     * Fetches a single comic series by id.
     * This method fetches a single comic series resource.  It is the canonical URI for any comic series resource provided by the API.
     * @param seriesId Filter by series title. (required)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("series/{seriesId}")
    suspend fun getSeriesIndividual(@Path("seriesId") seriesId: Int): Response<ResponseBody>

    /**
     * Fetches lists of stories filtered by a series id.
     * Fetches lists of comic stories from a specific series with optional filters. See notes on individual parameters below.
     * @param seriesId The series ID. (required)
     * @param modifiedSince Return only stories which have been modified since the specified date. (optional)
     * @param comics Return only stories contained in the specified (accepts a comma-separated list of ids). (optional)
     * @param events Return only stories which take place during the specified events (accepts a comma-separated list of ids). (optional)
     * @param creators Return only stories which feature work by the specified creators (accepts a comma-separated list of ids). (optional)
     * @param characters Return only stories which feature the specified characters (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("series/{seriesId}/stories")
    suspend fun getSeriesStoryCollection(
        @Path("seriesId") seriesId: Int,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("comics") comics: Array<Int>? = null,
        @Query("events") events: Array<Int>? = null,
        @Query("creators") creators: Array<Int>? = null,
        @Query("characters") characters: Array<Int>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>

    /**
     * Fetches lists of comics filtered by a series id.
     * Fetches lists of comics which are published as part of a specific series, with optional filters. See notes on individual parameters below.
     * @param seriesId The series ID. (required)
     * @param format Filter by the issue format (e.g. comic, digital comic, hardcover). (optional)
     * @param formatType Filter by the issue format type (comic or collection). (optional)
     * @param noVariants Exclude variant comics from the result set. (optional)
     * @param dateDescriptor Return comics within a predefined date range. (optional)
     * @param dateRange Return comics within a predefined date range.  Dates must be specified as date1,date2 (e.g. 2013-01-01,2013-01-02).  Dates are preferably formatted as YYYY-MM-DD but may be sent as any common date format. (optional)
     * @param title Return only issues in series whose title matches the input. (optional)
     * @param titleStartsWith Return only issues in series whose title starts with the input. (optional)
     * @param startYear Return only issues in series whose start year matches the input. (optional)
     * @param issueNumber Return only issues in series whose issue number matches the input. (optional)
     * @param diamondCode Filter by diamond code. (optional)
     * @param digitalId Filter by digital comic id. (optional)
     * @param upc Filter by UPC. (optional)
     * @param isbn Filter by ISBN. (optional)
     * @param ean Filter by EAN. (optional)
     * @param issn Filter by ISSN. (optional)
     * @param hasDigitalIssue Include only results which are available digitally. (optional)
     * @param modifiedSince Return only comics which have been modified since the specified date. (optional)
     * @param creators Return only comics which feature work by the specified creators (accepts a comma-separated list of ids). (optional)
     * @param characters Return only comics which feature the specified characters (accepts a comma-separated list of ids). (optional)
     * @param events Return only comics which take place in the specified events (accepts a comma-separated list of ids). (optional)
     * @param stories Return only comics which contain the specified stories (accepts a comma-separated list of ids). (optional)
     * @param sharedAppearances Return only comics in which the specified characters appear together (for example in which BOTH Spider-Man and Wolverine appear). (optional)
     * @param collaborators Return only comics in which the specified creators worked together (for example in which BOTH Stan Lee and Jack Kirby did work). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("series/{seriesId}/comics")
    suspend fun getComicsCollection_1(
        @Path("seriesId") seriesId: Int,
        @Query("format") format: String,
        @Query("formatType") formatType: String,
        @Query("noVariants") noVariants: Array<Boolean>,
        @Query("dateDescriptor") dateDescriptor: Array<String>,
        @Query("dateRange") dateRange: Array<Int>,
        @Query("title") title: String,
        @Query("titleStartsWith") titleStartsWith: String,
        @Query("startYear") startYear: Int,
        @Query("issueNumber") issueNumber: Int,
        @Query("diamondCode") diamondCode: String,
        @Query("digitalId") digitalId: Int,
        @Query("upc") upc: String,
        @Query("isbn") isbn: String,
        @Query("ean") ean: String,
        @Query("issn") issn: String,
        @Query("hasDigitalIssue") hasDigitalIssue: Array<Boolean>,
        @Query("modifiedSince") modifiedSince: String,
        @Query("creators") creators: Array<Int>,
        @Query("characters") characters: Array<Int>,
        @Query("events") events: Array<Int>,
        @Query("stories") stories: Array<Int>,
        @Query("sharedAppearances") sharedAppearances: Array<Int>,
        @Query("collaborators") collaborators: Array<Int>,
        @Query("orderBy") orderBy: Array<String>,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<ResponseBody>

    /**
     * Fetches lists of creators filtered by a series id.
     * Fetches lists of comic creators whose work appears in a specific series, with optional filters. See notes on individual parameters below.
     * @param seriesId The series ID. (required)
     * @param firstName Filter by creator first name (e.g. brian). (optional)
     * @param middleName Filter by creator middle name (e.g. Michael). (optional)
     * @param lastName Filter by creator last name (e.g. Bendis). (optional)
     * @param suffix Filter by suffix or honorific (e.g. Jr., Sr.). (optional)
     * @param nameStartsWith Filter by creator names that match critera (e.g. B, St L). (optional)
     * @param firstNameStartsWith Filter by creator first names that match critera (e.g. B, St L). (optional)
     * @param middleNameStartsWith Filter by creator middle names that match critera (e.g. Mi). (optional)
     * @param lastNameStartsWith Filter by creator last names that match critera (e.g. Ben). (optional)
     * @param modifiedSince Return only creators which have been modified since the specified date. (optional)
     * @param comics Return only creators who worked on in the specified comics (accepts a comma-separated list of ids). (optional)
     * @param events Return only creators who worked on comics that took place in the specified events (accepts a comma-separated list of ids). (optional)
     * @param stories Return only creators who worked on the specified stories (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("series/{seriesId}/creators")
    suspend fun getCreatorCollection_1(
        @Path("seriesId") seriesId: Int,
        @Query("firstName") firstName: String,
        @Query("middleName") middleName: String,
        @Query("lastName") lastName: String,
        @Query("suffix") suffix: String,
        @Query("nameStartsWith") nameStartsWith: String,
        @Query("firstNameStartsWith") firstNameStartsWith: String,
        @Query("middleNameStartsWith") middleNameStartsWith: String,
        @Query("lastNameStartsWith") lastNameStartsWith: String,
        @Query("modifiedSince") modifiedSince: String,
        @Query("comics") comics: Array<Int>,
        @Query("events") events: Array<Int>,
        @Query("stories") stories: Array<Int>,
        @Query("orderBy") orderBy: Array<String>,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<ResponseBody>

    /**
     * Fetches lists of events filtered by a series id.
     * Fetches lists of events which occur in a specific series, with optional filters. See notes on individual parameters below.
     * @param seriesId The series ID. (required)
     * @param name Filter the event list by name. (optional)
     * @param nameStartsWith Return events with names that begin with the specified string (e.g. Sp). (optional)
     * @param modifiedSince Return only events which have been modified since the specified date. (optional)
     * @param creators Return only events which feature work by the specified creators (accepts a comma-separated list of ids). (optional)
     * @param characters Return only events which feature the specified characters (accepts a comma-separated list of ids). (optional)
     * @param comics Return only events which take place in the specified comics (accepts a comma-separated list of ids). (optional)
     * @param stories Return only events which contain the specified stories (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("series/{seriesId}/events")
    suspend fun getEventsCollection_0(
        @Path("seriesId") seriesId: Int,
        @Query("name") name: String,
        @Query("nameStartsWith") nameStartsWith: String,
        @Query("modifiedSince") modifiedSince: String,
        @Query("creators") creators: Array<Int>,
        @Query("characters") characters: Array<Int>,
        @Query("comics") comics: Array<Int>,
        @Query("stories") stories: Array<Int>,
        @Query("orderBy") orderBy: Array<String>,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<ResponseBody>
}