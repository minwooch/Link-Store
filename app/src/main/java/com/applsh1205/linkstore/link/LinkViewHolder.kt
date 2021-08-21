package com.applsh1205.linkstore.link

import androidx.recyclerview.widget.RecyclerView
import com.applsh1205.linkstore.database.Link
import com.applsh1205.linkstore.databinding.ListItemLinkBinding

class LinkViewHolder(
    private val binding: ListItemLinkBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Link) {
        binding.link = item
        binding.executePendingBindings()
    }

}