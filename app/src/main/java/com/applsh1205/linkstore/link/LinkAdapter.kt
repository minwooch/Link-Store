package com.applsh1205.linkstore.link

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.applsh1205.linkstore.database.Link
import com.applsh1205.linkstore.databinding.ListItemLinkBinding

class LinkAdapter : PagingDataAdapter<Link, LinkViewHolder>(LinkDiffCallback()) {

    override fun onBindViewHolder(holder: LinkViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinkViewHolder {
        return LinkViewHolder(
            ListItemLinkBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private class LinkDiffCallback : DiffUtil.ItemCallback<Link>() {
        override fun areItemsTheSame(oldItem: Link, newItem: Link): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Link, newItem: Link): Boolean {
            return oldItem == newItem
        }
    }
}