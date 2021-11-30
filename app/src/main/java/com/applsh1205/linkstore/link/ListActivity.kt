package com.applsh1205.linkstore.link

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.applsh1205.linkstore.LinkApplication
import com.applsh1205.linkstore.R
import com.applsh1205.linkstore.databinding.ActivityListBinding
import com.applsh1205.linkstore.edit_link.EditLinkActivity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private val viewModel: ListViewModel by viewModels {
        (application as LinkApplication).appComponent
            .viewModelFactoryComponentFactory()
            .create()
            .viewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        binding.lifecycleOwner = this

        val linkAdapter = LinkAdapter()
        binding.linkRecyclerView.adapter = linkAdapter
        binding.linkRecyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            launch {
                viewModel.links.collect {
                    linkAdapter.submitData(it)
                }
            }

            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.browserLink.collect {
                        if (it.isNotEmpty()) {
                            val intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(it))
                            startActivity(intent)
                            viewModel.clearBrowserLink()
                        }
                    }
                }

                launch {
                    viewModel.editLink.collect {
                        if (it.isNotEmpty()) {
                            val intent = Intent(this@ListActivity, EditLinkActivity::class.java)
                            intent.putExtra("id", it)
                            startActivity(intent)
                            viewModel.clearEditLink()
                        }
                    }
                }
            }
        }

    }
}