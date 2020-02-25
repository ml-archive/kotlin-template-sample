package dk.nodes.template.presentation.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import dk.nodes.arch.presentation.NodesActivity
import dk.nodes.template.domain.extensions.guard
import dk.nodes.template.presentation.R

class MainActivity : NodesActivity(R.layout.activity_main) {

    private val viewModel by viewModel<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState.guard { viewModel.checkNStack() }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, MainActivity::class.java)
            .apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
    }
}