package com.applsh1205.linkstore.inject

import androidx.lifecycle.ViewModel
import dagger.Subcomponent
import javax.inject.Provider

@Subcomponent(modules = [ViewModelModule::class])
interface ViewModelComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ViewModelComponent
    }

    fun viewModelMap(): Map<Class<out ViewModel>, Provider<ViewModel>>
}