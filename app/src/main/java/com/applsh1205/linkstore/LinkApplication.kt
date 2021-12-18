package com.applsh1205.linkstore

import android.app.Application
import com.applsh1205.linkstore.inject.AppComponent
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LinkApplication : Application() {

    val appComponent: AppComponent by lazy { EntryPointAccessors.fromApplication(this, AppComponent::class.java) }
}