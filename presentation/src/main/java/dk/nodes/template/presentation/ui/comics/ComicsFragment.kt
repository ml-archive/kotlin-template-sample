package dk.nodes.template.presentation.ui.comics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dk.nodes.template.presentation.R
import dk.nodes.template.presentation.extensions.observeNonNull
import dk.nodes.template.presentation.ui.base.BaseFragment
import dk.nodes.template.presentation.ui.comicdetail.ComicDetailFragmentArgs
import dk.nodes.template.presentation.ui.shared.EndlessRecyclerViewScrollListener
import dk.nodes.template.presentation.util.consume
import kotlinx.android.synthetic.main.fragment_comics.*

class ComicsFragment : BaseFragment() {

    private val viewModel by viewModel<ComicsViewModel>()

    private lateinit var adapter: ComicsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ComicsAdapter {
            view.findNavController().navigate(
                R.id.comicsDetailFragment, ComicDetailFragmentArgs(it.id).toBundle()
            )
        }.also(comicsRv::setAdapter)

        comicsRv.layoutManager = LinearLayoutManager(context).also { linearLayoutManager ->
            comicsRv.addOnScrollListener(object :
                EndlessRecyclerViewScrollListener(linearLayoutManager) {
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
