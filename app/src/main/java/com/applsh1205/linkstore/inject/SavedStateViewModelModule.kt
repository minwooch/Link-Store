package com.applsh1205.linkstore.inject

import androidx.lifecycle.ViewModel
import com.applsh1205.linkstore.add_link.AddLinkViewModel
import com.applsh1205.linkstore.edit_link.EditLinkViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap

@InstallIn(HiltSavedStateViewModelComponent::class)
@Module
abstract class SavedStateViewModelModule {

    @IntoMap
    @ViewModelKey(EditLinkViewModel::class)
    @Binds
    abstract fun provideEditLinkViewModel(viewModel: EditLinkViewModel): ViewModel

    @IntoMap
    @ViewModelKey(AddLinkViewModel::class)
    @Binds
    abstract fun provideAddLinkViewModel(viewModel: AddLinkViewModel): ViewModel
}