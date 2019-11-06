package dk.nodes.template.models.dto

/**
 *
 * @param code The HTTP status code of the returned result.
 * @param status A string description of the call status.
 * @param copyright The copyright notice for the returned result.
 * @param attributionText The attribution notice for this result.  Please display either this notice or the contents of the attributionHTML field on all screens which contain data from the Marvel Comics API.
 * @param attributionHTML An HTML representation of the attribution notice for this result.  Please display either this notice or the contents of the attributionText field on all screens which contain data from the Marvel Comics API.
 * @param _data The results returned by the call.
 * @param etag A digest value of the content returned by the call.
 */
data class StoryDataWrapper(
    /* The HTTP status code of the returned result. */
    val code: Int? = null,

    /* A string description of the call status. */
    val status: String? = null,

    /* The copyright notice for the returned result. */
    val copyright: String? = null,

    /* The attribution notice for this result.  Please display either this notice or the contents of the attributionHTML field on all screens which contain data from the Marvel Comics API. */
    val attributionText: String? = null,

    /* An HTML representation of the attribution notice for this result.  Please display either this notice or the contents of the attributionText field on all screens which contain data from the Marvel Comics API. */
    val attributionHTML: String? = null,

    /* The results returned by the call. */
    val _data: StoryDataContainer? = null,

    /* A digest value of the content returned by the call. */
    val etag: String? = null
)
