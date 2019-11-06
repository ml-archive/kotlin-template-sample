package dk.nodes.template.presentation.ui.comicdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dk.nodes.template.models.entity.ComicEntity
import dk.nodes.template.presentation.R
import dk.nodes.template.presentation.extensions.observeNonNull
import dk.nodes.template.presentation.ui.base.BaseFragment
import dk.nodes.template.presentation.util.consume
import kotlinx.android.synthetic.main.fragment_comicdetail.*

class ComicDetailFragment : BaseFragment() {

    private val viewModel by viewModel<ComicDetailViewModel>()

    private val args: ComicDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.comicId = args.comicId
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comicdetail, container, false)
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