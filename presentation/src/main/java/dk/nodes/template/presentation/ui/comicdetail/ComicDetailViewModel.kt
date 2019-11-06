package dk.nodes.template.presentation.ui.comicdetail

import androidx.lifecycle.viewModelScope
import dk.nodes.template.domain.interactors.GetComicByIdInteractor
import dk.nodes.template.domain.interactors.asResult
import dk.nodes.template.domain.interactors.isError
import dk.nodes.template.domain.interactors.isSuccess
import dk.nodes.template.presentation.ui.base.BaseViewModel
import dk.nodes.template.presentation.util.SingleEvent
import dk.nodes.template.presentation.util.toViewError
import kotlinx.coroutines.launch
import javax.inject.Inject

class ComicDetailViewModel @Inject constructor(private val getComicByIdInteractor: GetComicByIdInteractor) :
    BaseViewModel<ComicDetailViewState>() {

    override val initState: ComicDetailViewState = ComicDetailViewState()
    var comicId: Long = 0
        set(value) {
            if (field != value) {
                field = value
                loadComicById(field)
            }
        }

    private fun loadComicById(comicId: Long) {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            getComicByIdInteractor.asResult().invoke(comicId)
                .isSuccess {
                    state = state.copy(isLoading = false, data = it)
                }
                .isError {
                    state = state.copy(isLoading = false, viewError = SingleEvent(it.toViewError()))
                }
        }
    }
}
