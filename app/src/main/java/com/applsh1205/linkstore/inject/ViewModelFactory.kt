package com.applsh1205.linkstore.inject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val viewModelComponentFactory: ViewModelComponent.Factory
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModelProvider = viewModelComponentFactory.create()
            .viewModelMap()
            .get(modelClass) ?: throw RuntimeException("${modelClass}가 없음")

        return viewModelProvider.get() as T
    }
}