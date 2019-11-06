package dk.nodes.template.network

import dk.nodes.template.models.dto.ComicDataWrapper
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicApi {

    /**
     * Fetches lists of characters filtered by a comic id.
     * Fetches lists of characters which appear in a specific comic with optional filters. See notes on individual parameters below.
     * @param comicId The comic id. (required)
     * @param name Return only characters matching the specified full character name (e.g. Spider-Man). (optional)
     * @param nameStartsWith Return characters with names that begin with the specified string (e.g. Sp). (optional)
     * @param modifiedSince Return only characters which have been modified since the specified date. (optional)
     * @param series Return only characters which appear the specified series (accepts a comma-separated list of ids). (optional)
     * @param events Return only characters which appear comics that took place in the specified events (accepts a comma-separated list of ids). (optional)
     * @param stories Return only characters which appear the specified stories (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("comics/{comicId}/characters")
    suspend fun getComicCharacterCollection(
        @Path("comicId") comicId: Int,
        @Query("name") name: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("series") series: Array<Int>? = null,
        @Query("events") events: Array<Int>? = null,
        @Query("stories") stories: Array<Int>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>

    /**
     * Fetches a single comic by id.
     * This method fetches a single comic resource.  It is the canonical URI for any comic resource provided by the API.
     * @param comicId A single comic. (required)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("comics/{comicId}")
    suspend fun getComicIndividual(@Path("comicId") comicId: Long): Response<ComicDataWrapper>

    /**
     * Fetches lists of stories filtered by a comic id.
     * Fetches lists of comic stories in a specific comic issue, with optional filters. See notes on individual parameters below.
     * @param comicId The comic ID. (required)
     * @param modifiedSince Return only stories which have been modified since the specified date. (optional)
     * @param series Return only stories contained the specified series (accepts a comma-separated list of ids). (optional)
     * @param events Return only stories which take place during the specified events (accepts a comma-separated list of ids). (optional)
     * @param creators Return only stories which feature work by the specified creators (accepts a comma-separated list of ids). (optional)
     * @param characters Return only stories which feature the specified characters (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("comics/{comicId}/stories")
    suspend fun getComicStoryCollection(
        @Path("comicId") comicId: Int,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("series") series: Array<Int>? = null,
        @Query("events") events: Array<Int>? = null,
        @Query("creators") creators: Array<Int>? = null,
        @Query("characters") characters: Array<Int>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>

    /**
     * Fetches lists of comics filtered by a creator id.
     * Fetches lists of comics in which the work of a specific creator appears, with optional filters. See notes on individual parameters below.
     * @param creatorId The creator ID. (required)
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
     * @param characters Return only comics which feature the specified characters (accepts a comma-separated list of ids). (optional)
     * @param series Return only comics which are part of the specified series (accepts a comma-separated list of ids). (optional)
     * @param events Return only comics which take place in the specified events (accepts a comma-separated list of ids). (optional)
     * @param stories Return only comics which contain the specified stories (accepts a comma-separated list of ids). (optional)
     * @param sharedAppearances Return only comics in which the specified characters appear together (for example in which BOTH Spider-Man and Wolverine appear). (optional)
     * @param collaborators Return only comics in which the specified creators worked together (for example in which BOTH Stan Lee and Jack Kirby did work). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("creators/{creatorId}/comics")
    suspend fun getComicsCollection(
        @Path("creatorId") creatorId: Int,
        @Query("format") format: String? = null,
        @Query("formatType") formatType: String? = null,
        @Query("noVariants") noVariants: Boolean? = null,
        @Query("dateDescriptor") dateDescriptor: String? = null,
        @Query("dateRange") dateRange: Array<Int>? = null,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null,
        @Query("issueNumber") issueNumber: Int? = null,
        @Query("diamondCode") diamondCode: String? = null,
        @Query("digitalId") digitalId: Int? = null,
        @Query("upc") upc: String? = null,
        @Query("isbn") isbn: String? = null,
        @Query("ean") ean: String? = null,
        @Query("issn") issn: String? = null,
        @Query("hasDigitalIssue") hasDigitalIssue: Array<Boolean>? = null,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("characters") characters: Array<Int>? = null,
        @Query("series") series: Array<Int>? = null,
        @Query("events") events: Array<Int>? = null,
        @Query("stories") stories: Array<Int>? = null,
        @Query("sharedAppearances") sharedAppearances: Array<Int>? = null,
        @Query("collaborators") collaborators: Array<Int>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>

    /**
     * Fetches lists of comics filtered by an event id.
     * Fetches lists of comics which take place during a specific event, with optional filters. See notes on individual parameters below.
     * @param eventId The event id. (required)
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
     * @param stories Return only comics which contain the specified stories (accepts a comma-separated list of ids). (optional)
     * @param sharedAppearances Return only comics in which the specified characters appear together (for example in which BOTH Spider-Man and Wolverine appear). (optional)
     * @param collaborators Return only comics in which the specified creators worked together (for example in which BOTH Stan Lee and Jack Kirby did work). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("events/{eventId}/comics")
    suspend fun getComicsCollection_0(
        @Path("eventId") eventId: Int,
        @Query("format") format: String? = null,
        @Query("formatType") formatType: String? = null,
        @Query("noVariants") noVariants: Array<Boolean>? = null,
        @Query("dateDescriptor") dateDescriptor: Array<String>? = null,
        @Query("dateRange") dateRange: Array<Int>? = null,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null,
        @Query("issueNumber") issueNumber: Int? = null,
        @Query("diamondCode") diamondCode: String? = null,
        @Query("digitalId") digitalId: Int? = null,
        @Query("upc") upc: String? = null,
        @Query("isbn") isbn: String? = null,
        @Query("ean") ean: String? = null,
        @Query("issn") issn: String? = null,
        @Query("hasDigitalIssue") hasDigitalIssue: Array<Boolean>? = null,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("creators") creators: Array<Int>? = null,
        @Query("characters") characters: Array<Int>? = null,
        @Query("series") series: Array<Int>? = null,
        @Query("events") events: Array<Int>? = null,
        @Query("stories") stories: Array<Int>? = null,
        @Query("sharedAppearances") sharedAppearances: Array<Int>? = null,
        @Query("collaborators") collaborators: Array<Int>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>

    /**
     * Fetches lists of comics.
     * Fetches lists of comics with optional filters. See notes on individual parameters below.
     * @param format Filter by the issue format (e.g. comic, digital comic, hardcover). (optional)
     * @param formatType Filter by the issue format type (comic or collection). (optional)
     * @param noVariants Exclude variants (alternate covers, secondary printings, director&#39;s cuts, etc.) from the result set. (optional)
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
     * @param stories Return only comics which contain the specified stories (accepts a comma-separated list of ids). (optional)
     * @param sharedAppearances Return only comics in which the specified characters appear together (for example in which BOTH Spider-Man and Wolverine appear). Accepts a comma-separated list of ids. (optional)
     * @param collaborators Return only comics in which the specified creators worked together (for example in which BOTH Stan Lee and Jack Kirby did work). Accepts a comma-separated list of ids. (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("comics")
    suspend fun getComicsCollection(
        @Query("format") format: String? = null,
        @Query("formatType") formatType: String? = null,
        @Query("noVariants") noVariants: Boolean? = null,
        @Query("dateDescriptor") dateDescriptor: String? = null,
        @Query("dateRange") dateRange: Array<Int>? = null,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null,
        @Query("issueNumber") issueNumber: Int? = null,
        @Query("diamondCode") diamondCode: String? = null,
        @Query("digitalId") digitalId: Int? = null,
        @Query("upc") upc: String? = null,
        @Query("isbn") isbn: String? = null,
        @Query("ean") ean: String? = null,
        @Query("issn") issn: String? = null,
        @Query("hasDigitalIssue") hasDigitalIssue: Boolean? = null,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("creators") creators: Array<Int>? = null,
        @Query("characters") characters: Array<Int>? = null,
        @Query("series") series: Array<Int>? = null,
        @Query("events") events: Array<Int>? = null,
        @Query("stories") stories: Array<Int>? = null,
        @Query("sharedAppearances") sharedAppearances: Array<Int>? = null,
        @Query("collaborators") collaborators: Array<Int>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ComicDataWrapper>

    /**
     * Fetches lists of creators.
     * Fetches lists of comic creators with optional filters. See notes on individual parameters below.
     * @param firstName Filter by creator first name (e.g. Brian). (optional)
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
     * @param stories Return only creators who worked on the specified stories (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("creators")
    suspend fun getCreatorCollection(
        @Query("firstName") firstName: String? = null,
        @Query("middleName") middleName: String? = null,
        @Query("lastName") lastName: String? = null,
        @Query("suffix") suffix: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("firstNameStartsWith") firstNameStartsWith: String? = null,
        @Query("middleNameStartsWith") middleNameStartsWith: String? = null,
        @Query("lastNameStartsWith") lastNameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("comics") comics: Array<Int>? = null,
        @Query("series") series: Array<Int>? = null,
        @Query("events") events: Array<Int>? = null,
        @Query("stories") stories: Array<Int>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>

    /**
     * Fetches lists of characters filtered by a story id.
     * Fetches lists of comic characters appearing in a single story, with optional filters. See notes on individual parameters below.
     * @param storyId The story ID. (required)
     * @param name Return only characters matching the specified full character name (e.g. Spider-Man). (optional)
     * @param nameStartsWith Return characters with names that begin with the specified string (e.g. Sp). (optional)
     * @param modifiedSince Return only characters which have been modified since the specified date. (optional)
     * @param comics Return only characters which appear in the specified comics (accepts a comma-separated list of ids). (optional)
     * @param series Return only characters which appear the specified series (accepts a comma-separated list of ids). (optional)
     * @param events Return only characters which appear comics that took place in the specified events (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("stories/{storyId}/characters")
    suspend fun getCreatorCollection(
        @Path("storyId") storyId: Int,
        @Query("name") name: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("comics") comics: Array<Int>? = null,
        @Query("series") series: Array<Int>? = null,
        @Query("events") events: Array<Int>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>

    /**
     * Fetches lists of creators filtered by a comic id.
     * Fetches lists of comic creators whose work appears in a specific comic, with optional filters. See notes on individual parameters below.
     * @param comicId The comic id. (required)
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
     * @param stories Return only creators who worked on the specified stories (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("comics/{comicId}/creators")
    suspend fun getCreatorCollection(
        @Path("comicId") comicId: Int,
        @Query("firstName") firstName: String? = null,
        @Query("middleName") middleName: String? = null,
        @Query("lastName") lastName: String? = null,
        @Query("suffix") suffix: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("firstNameStartsWith") firstNameStartsWith: String? = null,
        @Query("middleNameStartsWith") middleNameStartsWith: String? = null,
        @Query("lastNameStartsWith") lastNameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("comics") comics: Array<Int>? = null,
        @Query("series") series: Array<Int>? = null,
        @Query("stories") stories: Array<Int>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>

    /**
     * Fetches lists of characters.
     * Fetches lists of comic characters with optional filters. See notes on individual parameters below.
     * @param name Return only characters matching the specified full character name (e.g. Spider-Man). (optional)
     * @param nameStartsWith Return characters with names that begin with the specified string (e.g. Sp). (optional)
     * @param modifiedSince Return only characters which have been modified since the specified date. (optional)
     * @param comics Return only characters which appear in the specified comics (accepts a comma-separated list of ids). (optional)
     * @param series Return only characters which appear the specified series (accepts a comma-separated list of ids). (optional)
     * @param events Return only characters which appear in the specified events (accepts a comma-separated list of ids). (optional)
     * @param stories Return only characters which appear the specified stories (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("characters")
    suspend fun getCharacterCollection(
        @Query("name") name: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("comics") comics: Array<Int>? = null,
        @Query("series") series: Array<Int>? = null,
        @Query("events") events: Array<Int>? = null,
        @Query("stories") stories: Array<Int>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>

    /**
     * Fetches lists of creators filtered by an event id.
     * Fetches lists of comic creators whose work appears in a specific event, with optional filters. See notes on individual parameters below.
     * @param eventId The event ID. (required)
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
     * @param stories Return only creators who worked on the specified stories (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("events/{eventId}/creators")
    suspend fun getCreatorCollection_5(
        @Path("eventId") eventId: Int,
        @Query("firstName") firstName: String? = null,
        @Query("middleName") middleName: String? = null,
        @Query("lastName") lastName: String? = null,
        @Query("suffix") suffix: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("firstNameStartsWith") firstNameStartsWith: String? = null,
        @Query("middleNameStartsWith") middleNameStartsWith: String? = null,
        @Query("lastNameStartsWith") lastNameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("comics") comics: Array<Int>? = null,
        @Query("series") series: Array<Int>? = null,
        @Query("stories") stories: Array<Int>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>

    /**
     * Fetches lists of events filtered by a creator id.
     * Fetches lists of events featuring the work of a specific creator with optional filters. See notes on individual parameters below.
     * @param creatorId The creator ID. (required)
     * @param name Filter the event list by name. (optional)
     * @param nameStartsWith Return events with names that begin with the specified string (e.g. Sp). (optional)
     * @param modifiedSince Return only events which have been modified since the specified date. (optional)
     * @param characters Return only events which feature the specified characters (accepts a comma-separated list of ids). (optional)
     * @param series Return only events which are part of the specified series (accepts a comma-separated list of ids). (optional)
     * @param comics Return only events which take place in the specified comics (accepts a comma-separated list of ids). (optional)
     * @param stories Return only events which contain the specified stories (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("creators/{creatorId}/events")
    suspend fun getCreatorEventsCollection(
        @Path("creatorId") creatorId: Int,
        @Query("name") name: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("characters") characters: Array<Int>? = null,
        @Query("series") series: Array<Int>? = null,
        @Query("comics") comics: Array<Int>? = null,
        @Query("stories") stories: Array<Int>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>

    /**
     * Fetches a single creator by id.
     * This method fetches a single creator resource.  It is the canonical URI for any creator resource provided by the API.
     * @param creatorId A single creator id. (required)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("creators/{creatorId}")
    suspend fun getCreatorIndividual(@Path("creatorId") creatorId: Int): Response<ResponseBody>

    /**
     * Fetches lists of series filtered by a creator id.
     * Fetches lists of comic series in which a specific creator&#39;s work appears, with optional filters. See notes on individual parameters below.
     * @param creatorId The creator ID. (required)
     * @param title Filter by series title. (optional)
     * @param titleStartsWith Return series with titles that begin with the specified string (e.g. Sp). (optional)
     * @param startYear Return only series matching the specified start year. (optional)
     * @param modifiedSince Return only series which have been modified since the specified date. (optional)
     * @param comics Return only series which contain the specified comics (accepts a comma-separated list of ids). (optional)
     * @param stories Return only series which contain the specified stories (accepts a comma-separated list of ids). (optional)
     * @param events Return only series which have comics that take place during the specified events (accepts a comma-separated list of ids). (optional)
     * @param characters Return only series which feature the specified characters (accepts a comma-separated list of ids). (optional)
     * @param seriesType Filter the series by publication frequency type. (optional)
     * @param contains Return only series containing one or more comics with the specified format. (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("creators/{creatorId}/series")
    suspend fun getCreatorSeriesCollection(
        @Path("creatorId") creatorId: Int,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("comics") comics: Array<Int>? = null,
        @Query("stories") stories: Array<Int>? = null,
        @Query("events") events: Array<Int>? = null,
        @Query("characters") characters: Array<Int>? = null,
        @Query("seriesType") seriesType: String? = null,
        @Query("contains") contains: Array<String>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>

    /**
     * Fetches lists of stories filtered by a creator id.
     * Fetches lists of comic stories by a specific creator with optional filters. See notes on individual parameters below.
     * @param creatorId The ID of the creator. (required)
     * @param modifiedSince Return only stories which have been modified since the specified date. (optional)
     * @param comics Return only stories contained in the specified comics (accepts a comma-separated list of ids). (optional)
     * @param series Return only stories contained the specified series (accepts a comma-separated list of ids). (optional)
     * @param events Return only stories which take place during the specified events (accepts a comma-separated list of ids). (optional)
     * @param characters Return only stories which feature the specified characters (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("creators/{creatorId}/stories")
    suspend fun getCreatorStoryCollection(
        @Path("creatorId") creatorId: Int,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("comics") comics: Array<Int>? = null,
        @Query("series") series: Array<Int>? = null,
        @Query("events") events: Array<Int>? = null,
        @Query("characters") characters: Array<Int>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>

    /**
     * Fetches lists of events filtered by a comic id.
     * Fetches lists of events in which a specific comic appears, with optional filters. See notes on individual parameters below.
     * @param comicId The comic ID. (required)
     * @param name Filter the event list by name. (optional)
     * @param nameStartsWith Return events with names that begin with the specified string (e.g. Sp). (optional)
     * @param modifiedSince Return only events which have been modified since the specified date. (optional)
     * @param creators Return only events which feature work by the specified creators (accepts a comma-separated list of ids). (optional)
     * @param characters Return only events which feature the specified characters (accepts a comma-separated list of ids). (optional)
     * @param series Return only events which are part of the specified series (accepts a comma-separated list of ids). (optional)
     * @param stories Return only events which contain the specified stories (accepts a comma-separated list of ids). (optional)
     * @param orderBy Order the result set by a field or fields. Add a \&quot;-\&quot; to the value sort in descending order. Multiple values are given priority in the order in which they are passed. (optional)
     * @param limit Limit the result set to the specified number of resources. (optional)
     * @param offset Skip the specified number of resources in the result set. (optional)
     * @return Call&lt;retrofit2.Response&lt;okhttp3.ResponseBody&gt;&gt;
     */
    @GET("comics/{comicId}/events")
    suspend fun getIssueEventsCollection(
        @Path("comicId") comicId: Int,
        @Query("name") name: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: String? = null,
        @Query("creators") creators: Array<Int>? = null,
        @Query("characters") characters: Array<Int>? = null,
        @Query("series") series: Array<Int>? = null,
        @Query("stories") stories: Array<Int>? = null,
        @Query("orderBy") orderBy: Array<String>? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ResponseBody>
}