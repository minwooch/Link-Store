package com.applsh1205.linkstore

import android.app.Application
import com.applsh1205.linkstore.database.AppDatabase

class LinkApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        AppDatabase.initialize(this)
    }
}