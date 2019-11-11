package dk.nodes.template.presentation.ui.base

import dk.nodes.arch.presentation.NodesFragment
import dk.nodes.template.presentation.util.ViewErrorController
import javax.inject.Inject

abstract class BaseFragment : NodesFragment() {

    @Inject lateinit var defaultErrorController: dagger.Lazy<ViewErrorController>
}
