package com.applsh1205.linkstore.add_link

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.applsh1205.linkstore.LinkApplication
import com.applsh1205.linkstore.R
import com.applsh1205.linkstore.databinding.ActivityAddLinkBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AddLinkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddLinkBinding

    private val viewModel: AddLinkViewModel by viewModels {
        (application as LinkApplication).appContainer.createAddLinkViewModelFactory(this, intent.extras)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_link)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.addLinkCancel.setOnClickListener {
            finish()
        }

        binding.addLinkDone.setOnClickListener {
            viewModel.addLink()
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.finish.collect {
                        if (it) {
                            finishAndRemoveTask()
                        }
                    }
                }
            }
        }

    }
}