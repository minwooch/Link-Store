package com.applsh1205.linkstore.inject

import androidx.lifecycle.ViewModel
import com.applsh1205.linkstore.link.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @IntoMap
    @ViewModelKey(ListViewModel::class)
    @Binds
    abstract fun provideListViewModel(viewModel: ListViewModel): ViewModel
}