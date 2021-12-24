package com.applsh1205.linkstore.inject

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.savedstate.SavedStateRegistryOwner
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

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

@InstallIn(ActivityComponent::class)
@EntryPoint
interface SavedStateViewModelEntryPoint {

    fun savedStateViewModelComponentFactory(): SavedStateViewModelComponent.Factory

    fun savedStateViewModelFactory(): SavedStateViewModelFactory
}

@InstallIn(ActivityComponent::class)
@Module
object ActivityModule {
    @Provides
    fun provideOwner(activity: Activity): SavedStateRegistryOwner {
        return (activity as ComponentActivity)
    }

    @Provides
    fun provideArgs(activity: Activity): Bundle? {
        return activity.intent.extras
    }
}