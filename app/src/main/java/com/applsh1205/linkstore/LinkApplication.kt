package com.applsh1205.linkstore

import android.app.Application
import com.applsh1205.linkstore.inject.AppContainer

class LinkApplication : Application() {

    val appContainer: AppContainer by lazy { AppContainer(applicationContext) }

}