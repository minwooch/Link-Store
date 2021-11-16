package com.applsh1205.linkstore.inject

import android.os.Bundle
import androidx.savedstate.SavedStateRegistryOwner
import com.applsh1205.linkstore.add_link.AddLinkViewModelFactory
import com.applsh1205.linkstore.edit_link.EditLinkViewModelFactory
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

    fun editLinkViewModelFactory(): EditLinkViewModelFactory
    fun addLinkViewModelFactory(): AddLinkViewModelFactory

}