package dk.nodes.template.presentation.ui.comicdetail

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import dk.nodes.arch.injection.ViewModelKey

@Module
abstract class ComicDetailBuilder {

    @ContributesAndroidInjector
    abstract fun ComicDetailFragment(): ComicDetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(ComicDetailViewModel::class)
    internal abstract fun bindComicDetailViewModel(viewModel: ComicDetailViewModel): ViewModel
}
