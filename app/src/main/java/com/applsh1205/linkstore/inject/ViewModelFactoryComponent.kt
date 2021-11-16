package com.applsh1205.linkstore.inject

import com.applsh1205.linkstore.link.ListViewModelFactory
import dagger.Subcomponent

@Subcomponent
interface ViewModelFactoryComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ViewModelFactoryComponent
    }

    fun listViewModelFactory(): ListViewModelFactory

}