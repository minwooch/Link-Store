package com.applsh1205.linkstore.inject

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.savedstate.SavedStateRegistryOwner
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

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