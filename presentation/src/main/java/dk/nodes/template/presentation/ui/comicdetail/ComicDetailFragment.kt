package dk.nodes.template.presentation.ui.comicdetail

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dk.nodes.arch.presentation.NodesFragment
import dk.nodes.template.models.entity.ComicEntity
import dk.nodes.template.presentation.R
import dk.nodes.template.presentation.extensions.observeNonNull
import dk.nodes.template.presentation.util.ViewErrorController
import dk.nodes.template.presentation.util.consume
import kotlinx.android.synthetic.main.fragment_comicdetail.*
import javax.inject.Inject

class ComicDetailFragment : NodesFragment(R.layout.fragment_comicdetail) {

    private val viewModel by viewModel<ComicDetailViewModel>()
    @Inject lateinit var defaultErrorController: dagger.Lazy<ViewErrorController>

    private val args: ComicDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.comicId = args.comicId
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.viewState.observeNonNull(this) { state ->
            state.data?.let(this::handleEntity)
            state.viewError.consume {
                defaultErrorController.get().showErrorSnackbar(requireView(), it)
            }
            state.isLoading
        }
    }

    private fun handleEntity(entity: ComicEntity) {
        comicTitleTv.text = entity.title
        Glide.with(comicIv)
            .load(entity.thumbnailPath)
            .into(comicIv)
    }
}