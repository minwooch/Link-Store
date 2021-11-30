package com.applsh1205.linkstore.inject

import dagger.Subcomponent

@Subcomponent
interface ViewModelFactoryComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ViewModelFactoryComponent
    }

    fun viewModelComponentFactory(): ViewModelComponent.Factory

    fun viewModelFactory(): ViewModelFactory

}