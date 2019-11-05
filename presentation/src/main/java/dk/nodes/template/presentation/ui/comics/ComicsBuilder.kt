package dk.nodes.template.presentation.ui.comics

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import dk.nodes.template.presentation.injection.ViewModelKey

@Module
abstract class ComicsBuilder {

    @ContributesAndroidInjector
    abstract fun ComicsFragment(): ComicsFragment

    @Binds
    @IntoMap
    @ViewModelKey(ComicsViewModel::class)
    internal abstract fun bindComicsViewModel(viewModel: ComicsViewModel): ViewModel
}
