package dk.nodes.template.presentation.ui.comicdetail

import dk.nodes.template.models.entity.ComicEntity
import dk.nodes.template.presentation.util.SingleEvent
import dk.nodes.template.presentation.util.ViewError

data class ComicDetailViewState(
    val data: ComicEntity? = null,
    val viewError: SingleEvent<ViewError>? = null,
    val isLoading: Boolean = false
)
