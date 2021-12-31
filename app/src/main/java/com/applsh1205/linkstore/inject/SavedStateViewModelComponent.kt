package com.applsh1205.linkstore.inject

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Provider

@DefineComponent(parent = ActivityComponent::class)
interface HiltSavedStateViewModelComponent {}

@DefineComponent.Builder
interface HiltSavedStateViewModelComponentBuilder {
    fun savedStateHandle(@BindsInstance savedStateHandle: SavedStateHandle): HiltSavedStateViewModelComponentBuilder
    fun build(): HiltSavedStateViewModelComponent
}

@InstallIn(HiltSavedStateViewModelComponent::class)
@EntryPoint
interface HiltSavedStateViewModelEntryPoint {
    fun viewModelMap(): Map<Class<out ViewModel>, Provider<ViewModel>>
}