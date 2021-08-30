package com.applsh1205.linkstore.link

import androidx.recyclerview.widget.RecyclerView
import com.applsh1205.linkstore.databinding.ListItemLinkBinding

class LinkViewHolder(
    private val binding: ListItemLinkBinding
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.listItemCardView.setOnClickListener {
            val currentLink = binding.link ?: return@setOnClickListener
            currentLink.onClick()
        }

        binding.listItemCardView.setOnLongClickListener {
            val currentLink = binding.link ?: return@setOnLongClickListener true
            currentLink.onLongClick()
            true
        }
    }

    fun bind(item: LinkItem) {
        binding.link = item
        binding.executePendingBindings()
    }

}