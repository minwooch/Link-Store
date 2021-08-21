package com.applsh1205.linkstore.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "links")
data class Link (
    @PrimaryKey
    val id: String,
    val url: String,
    val name: String,
    val description: String,
)