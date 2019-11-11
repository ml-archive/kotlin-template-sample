package dk.nodes.template.presentation.ui.base

import android.content.Context
import dk.nodes.arch.presentation.NodesActivity
import dk.nodes.nstack.kotlin.inflater.NStackBaseContext

abstract class BaseActivity : NodesActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(NStackBaseContext(newBase))
    }
}