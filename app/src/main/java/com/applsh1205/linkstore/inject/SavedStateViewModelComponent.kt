package com.applsh1205.linkstore.inject

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Provider

@Subcomponent(modules = [SavedStateViewModelModule::class])
interface SavedStateViewModelComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance savedStateHandle: SavedStateHandle): SavedStateViewModelComponent
    }

    fun viewModelMap(): Map<Class<out ViewModel>, Provider<ViewModel>>
}

@DefineComponent(parent = ActivityComponent::class)
interface HiltSavedStateViewModelComponent {}

@DefineComponent.Builder
interface HiltSavedStateViewModelComponentBuilder {
    fun savedStateHandle(@BindsInstance savedStateHandle: SavedStateHandle): HiltSavedStateViewModelComponentBuilder
    fun build(): HiltSavedStateViewModelComponent
}

@InstallIn(HiltSavedStateViewModelComponent::class)
@Module(includes = [SavedStateViewModelModule::class])
class HiltSavedStateViewModelModule

@InstallIn(HiltSavedStateViewModelComponent::class)
@EntryPoint
interface HiltSavedStateViewModelEntryPoint {
    fun viewModelMap(): Map<Class<out ViewModel>, Provider<ViewModel>>
}