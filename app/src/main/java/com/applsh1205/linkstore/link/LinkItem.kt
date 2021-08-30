package com.applsh1205.linkstore.link

data class LinkItem(
    val id: String,
    val url: String,
    val name: String,
    val description: String,
) {
    var onClick: () -> Unit = {}
    var onLongClick: () -> Unit = {}
}