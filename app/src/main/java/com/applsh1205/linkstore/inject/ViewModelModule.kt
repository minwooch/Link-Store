package com.applsh1205.linkstore.inject

import androidx.lifecycle.ViewModel
import com.applsh1205.linkstore.link.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap

@InstallIn(ActivityComponent::class)
@Module
abstract class ViewModelModule {

    @IntoMap
    @ViewModelKey(ListViewModel::class)
    @Binds
    abstract fun provideListViewModel(viewModel: ListViewModel): ViewModel
}