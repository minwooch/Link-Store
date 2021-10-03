package com.applsh1205.linkstore

import android.app.Application
import com.applsh1205.linkstore.database.AppDatabase
import com.applsh1205.linkstore.inject.AppContainer

class LinkApplication : Application() {

    val appContainer: AppContainer by lazy { AppContainer(applicationContext) }

    override fun onCreate() {
        super.onCreate()

        AppDatabase.initialize(this)
    }
}