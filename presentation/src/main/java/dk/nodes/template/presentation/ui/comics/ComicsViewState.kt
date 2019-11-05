package dk.nodes.template.presentation.ui.comics

import dk.nodes.template.models.entity.ComicEntity
import dk.nodes.template.presentation.util.SingleEvent
import dk.nodes.template.presentation.util.ViewError

data class ComicsViewState(
    val data: List<ComicEntity> = listOf(),
    val viewError: SingleEvent<ViewError>? = null,
    val isLoading: Boolean = false
)
