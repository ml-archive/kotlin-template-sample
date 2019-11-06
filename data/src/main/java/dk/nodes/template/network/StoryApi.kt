package dk.nodes.template.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StoryApi {
    /**
     * Fetches lists of creators filtered by a story id.
     * Fetches lists of comic creators whose work appears in a specific story, with optional filters. See notes on individual parameters below.
     * @param storyId The story ID. (required)
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
     * @param series Return only creators who worked on the specified series (accepts a comma-separated list of ids). (optional)
     * @param events Return only creators who worked on comics that took place in the specified events (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("stories/{storyId}/creators")
    suspend fun getCreatorCollection_4(
        @Path("storyId") storyId: Int,
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
        @Query("series") series: Array<Int>,
        @Query("events") events: Array<Int>,
        @Query("orderBy") orderBy: Array<String>,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<ResponseBody>

    /**
     * Fetches lists of events filtered by a story id.
     * Fetches lists of events in which a specific story appears, with optional filters. See notes on individual parameters below.
     * @param storyId The story ID. (required)
     * @param name Filter the event list by name. (optional)
     * @param nameStartsWith Return events with names that begin with the specified string (e.g. Sp). (optional)
     * @param modifiedSince Return only events which have been modified since the specified date. (optional)
     * @param creators Return only events which feature work by the specified creators (accepts a comma-separated list of ids). (optional)
     * @param characters Return only events which feature the specified characters (accepts a comma-separated list of ids). (optional)
     * @param series Return only events which are part of the specified series (accepts a comma-separated list of ids). (optional)
     * @param comics Return only events which take place in the specified comics (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("stories/{storyId}/events")
    suspend fun getEventsCollection(
        @Path("storyId") storyId: Int,
        @Query("name") name: String,
        @Query("nameStartsWith") nameStartsWith: String,
        @Query("modifiedSince") modifiedSince: String,
        @Query("creators") creators: Array<Int>,
        @Query("characters") characters: Array<Int>,
        @Query("series") series: Array<Int>,
        @Query("comics") comics: Array<Int>,
        @Query("orderBy") orderBy: Array<String>,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<ResponseBody>

    /**
     * Fetches lists of stories.
     * Fetches lists of comic stories with optional filters. See notes on individual parameters below.
     * @param modifiedSince Return only stories which have been modified since the specified date. (optional)
     * @param comics Return only stories contained in the specified (accepts a comma-separated list of ids). (optional)
     * @param series Return only stories contained the specified series (accepts a comma-separated list of ids). (optional)
     * @param events Return only stories which take place during the specified events (accepts a comma-separated list of ids). (optional)
     * @param creators Return only stories which feature work by the specified creators (accepts a comma-separated list of ids). (optional)
     * @param characters Return only stories which feature the specified characters (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("stories")
    suspend fun getStoryCollection(
        @Query("modifiedSince") modifiedSince: String,
        @Query("comics") comics: Array<Int>,
        @Query("series") series: Array<Int>,
        @Query("events") events: Array<Int>,
        @Query("creators") creators: Array<Int>,
        @Query("characters") characters: Array<Int>,
        @Query("orderBy") orderBy: Array<String>,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<ResponseBody>

    /**
     * Fetches a single comic story by id.
     * This method fetches a single comic story resource.  It is the canonical URI for any comic story resource provided by the API.
     * @param storyId Filter by story id. (required)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("stories/{storyId}")
    suspend fun getStoryIndividual(@Path("storyId") storyId: Int): Response<ResponseBody>

    /**
     * Fetches lists of series filtered by a story id.
     * Fetches lists of comic series in which the specified story takes place. See notes on individual parameters below.
     * @param storyId The story ID. (required)
     * @param events Return only series which have comics that take place during the specified events (accepts a comma-separated list of ids). (optional)
     * @param title Filter by series title. (optional)
     * @param titleStartsWith Return series with titles that begin with the specified string (e.g. Sp). (optional)
     * @param startYear Return only series matching the specified start year. (optional)
     * @param modifiedSince Return only series which have been modified since the specified date. (optional)
     * @param comics Return only series which contain the specified comics (accepts a comma-separated list of ids). (optional)
     * @param creators Return only series which feature work by the specified creators (accepts a comma-separated list of ids). (optional)
     * @param characters Return only series which feature the specified characters (accepts a comma-separated list of ids). (optional)
     * @param seriesType Filter the series by publication frequency type. (optional)
     * @param contains Return only series containing one or more comics with the specified format. (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("stories/{storyId}/series")
    suspend fun getStorySeriesCollection(
        @Path("storyId") storyId: Int,
        @Query("events") events: Array<Int>,
        @Query("title") title: String,
        @Query("titleStartsWith") titleStartsWith: String,
        @Query("startYear") startYear: Int,
        @Query("modifiedSince") modifiedSince: String,
        @Query("comics") comics: Array<Int>,
        @Query("creators") creators: Array<Int>,
        @Query("characters") characters: Array<Int>,
        @Query("seriesType") seriesType: String,
        @Query("contains") contains: Array<String>,
        @Query("orderBy") orderBy: Array<String>,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<ResponseBody>

    /**
     * Fetches lists of comics filtered by a story id.
     * Fetches lists of comics in which a specific story appears, with optional filters. See notes on individual parameters below.
     * @param storyId The story ID. (required)
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
     * @param series Return only comics which are part of the specified series (accepts a comma-separated list of ids). (optional)
     * @param events Return only comics which take place in the specified events (accepts a comma-separated list of ids). (optional)
     * @param sharedAppearances Return only comics in which the specified characters appear together (for example in which BOTH Spider-Man and Wolverine appear). (optional)
     * @param collaborators Return only comics in which the specified creators worked together (for example in which BOTH Stan Lee and Jack Kirby did work). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("stories/{storyId}/comics")
    suspend fun getComicsCollection_3(
        @Path("storyId") storyId: Int,
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
        @Query("series") series: Array<Int>,
        @Query("events") events: Array<Int>,
        @Query("sharedAppearances") sharedAppearances: Array<Int>,
        @Query("collaborators") collaborators: Array<Int>,
        @Query("orderBy") orderBy: Array<String>,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<ResponseBody>
}