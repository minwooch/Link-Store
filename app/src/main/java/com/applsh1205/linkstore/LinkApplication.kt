package com.applsh1205.linkstore

import android.app.Application
import com.applsh1205.linkstore.inject.AppComponent
import com.applsh1205.linkstore.inject.AppContainer
import com.applsh1205.linkstore.inject.DaggerAppComponent

class LinkApplication : Application() {

    val appContainer: AppContainer by lazy { AppContainer(applicationContext) }

    val appComponent: AppComponent by lazy { DaggerAppComponent.factory().create(applicationContext) }
}