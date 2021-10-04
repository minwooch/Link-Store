package com.applsh1205.linkstore.inject

import android.content.Context
import android.os.Bundle
import androidx.room.Room
import androidx.savedstate.SavedStateRegistryOwner
import com.applsh1205.linkstore.add_link.AddLinkViewModelFactory
import com.applsh1205.linkstore.database.AppDatabase
import com.applsh1205.linkstore.edit_link.EditLinkViewModelFactory
import com.applsh1205.linkstore.link.ListViewModelFactory
import com.applsh1205.linkstore.repository.DefaultLinkRepository
import com.applsh1205.linkstore.repository.LinkRepository

class AppContainer(private val applicationContext: Context) {

    private val appDatabase: AppDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "Link-DB.db"
        ).build()
    }

    private val linkRepository: LinkRepository by lazy {
        DefaultLinkRepository(appDatabase.linkDao())
    }

    fun createAddLinkViewModelFactory(
        owner: SavedStateRegistryOwner,
        defaultArgs: Bundle?
    ): AddLinkViewModelFactory {
        return AddLinkViewModelFactory(owner, defaultArgs, linkRepository)
    }

    fun createEditLinkViewModelFactory(
        owner: SavedStateRegistryOwner,
        defaultArgs: Bundle?
    ): EditLinkViewModelFactory {
        return EditLinkViewModelFactory(owner, defaultArgs, linkRepository)
    }

    fun createListViewModelFactory(): ListViewModelFactory {
        return ListViewModelFactory(linkRepository)
    }

}
