package com.applsh1205.linkstore.inject

import android.content.Context
import dagger.*
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@EntryPoint
interface AppComponent {

    fun savedStateViewModelFactoryComponentFactory(): SavedStateViewModelFactoryComponent.Factory
    fun viewModelFactoryComponentFactory(): ViewModelFactoryComponent.Factory

}

@InstallIn(SingletonComponent::class)
@Module(includes = [AppModule::class])
class HiltAppModule()

@InstallIn(SingletonComponent::class)
@Module
object ContextModule {
    @Provides
    fun provideContext(@ApplicationContext context: Context) : Context {
        return context
    }
}
