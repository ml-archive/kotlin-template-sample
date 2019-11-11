package dk.nodes.template.presentation.injection

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dk.nodes.arch.injection.DaggerViewModelFactory

@Module
abstract class ViewModelBuilder {

    @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}