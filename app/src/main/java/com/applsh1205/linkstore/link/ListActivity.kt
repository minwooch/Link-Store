package com.applsh1205.linkstore.link

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.applsh1205.linkstore.R
import com.applsh1205.linkstore.databinding.ActivityListBinding
import com.applsh1205.linkstore.edit_link.EditLinkActivity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private val viewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        binding.lifecycleOwner = this

        val linkAdapter = LinkAdapter()
        binding.linkRecyclerView.adapter = linkAdapter
        binding.linkRecyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            viewModel.links.collect {
                linkAdapter.submitData(it)
            }
        }

        viewModel.browserLink.observe(this) {
            if (it.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(it))
                startActivity(intent)
                viewModel.clearBrowserLink()
            }
        }

        viewModel.editLink.observe(this) {
            if (it.isNotEmpty()) {
                val intent = Intent(this, EditLinkActivity::class.java)
                intent.putExtra("id", it)
                startActivity(intent)
                viewModel.clearEditLink()
            }
        }

    }
}