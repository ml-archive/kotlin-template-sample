package dk.nodes.template.presentation.ui.comics

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dk.nodes.arch.presentation.NodesFragment
import dk.nodes.template.presentation.R
import dk.nodes.template.presentation.extensions.observeNonNull

import dk.nodes.template.presentation.ui.comicdetail.ComicDetailFragmentArgs
import dk.nodes.template.presentation.ui.shared.EndlessRecyclerViewScrollListener
import dk.nodes.template.presentation.util.ViewErrorController
import dk.nodes.template.presentation.util.consume
import kotlinx.android.synthetic.main.fragment_comics.*
import javax.inject.Inject

class ComicsFragment : NodesFragment(R.layout.fragment_comics) {

    private val viewModel by viewModel<ComicsViewModel>()

    @Inject lateinit var defaultErrorController: dagger.Lazy<ViewErrorController>

    private lateinit var adapter: ComicsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ComicsAdapter {
            view.findNavController().navigate(
                R.id.comicsDetailFragment, ComicDetailFragmentArgs(it.id).toBundle()
            )
        }.also(comicsRv::setAdapter)

        comicsRv.layoutManager = GridLayoutManager(context, 2).also { layoutManager ->
            comicsRv.addOnScrollListener(object :
                EndlessRecyclerViewScrollListener(layoutManager) {
                override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                    viewModel.loadMore(totalItemsCount)
                }
            })
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.viewState.observeNonNull(this) { state ->
            adapter.setData(state.data)
            state.viewError.consume {
                defaultErrorController.get().showErrorSnackbar(requireView(), it)
            }
            progressBar.isVisible = state.isLoading
        }
    }
}