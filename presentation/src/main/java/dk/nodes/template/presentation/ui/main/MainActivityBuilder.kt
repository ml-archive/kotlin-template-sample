package dk.nodes.template.presentation.ui.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import dk.nodes.arch.injection.ViewModelKey
import dk.nodes.template.presentation.ui.comicdetail.ComicDetailBuilder
import dk.nodes.template.presentation.ui.comics.ComicsBuilder
import dk.nodes.template.presentation.ui.sample.SampleBuilder

@Module
internal abstract class MainActivityBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewMode(viewModel: MainActivityViewModel): ViewModel

    @ContributesAndroidInjector(
        modules = [
            SampleBuilder::class,
            ComicsBuilder::class,
            ComicDetailBuilder::class
        ]
    )
    internal abstract fun mainActivity(): MainActivity
}