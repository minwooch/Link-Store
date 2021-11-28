package com.applsh1205.linkstore.inject

import android.os.Bundle
import androidx.savedstate.SavedStateRegistryOwner
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent
interface SavedStateViewModelFactoryComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance owner: SavedStateRegistryOwner,
            @BindsInstance defaultArgs: Bundle?
        ): SavedStateViewModelFactoryComponent
    }

    fun savedStateViewModelComponentFactory(): SavedStateViewModelComponent.Factory

    fun savedStateViewModelFactory(): SavedStateViewModelFactory
}