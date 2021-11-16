package com.applsh1205.linkstore.inject

import android.content.Context
import dagger.*

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun savedStateViewModelFactoryComponentFactory(): SavedStateViewModelFactoryComponent.Factory
    fun viewModelFactoryComponentFactory(): ViewModelFactoryComponent.Factory

}

