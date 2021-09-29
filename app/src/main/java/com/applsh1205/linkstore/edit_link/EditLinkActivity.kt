package com.applsh1205.linkstore.edit_link

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.applsh1205.linkstore.R
import com.applsh1205.linkstore.databinding.ActivityEditLinkBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class EditLinkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditLinkBinding

    private val viewModel: EditLinkViewModel by viewModels {
        EditLinkViewModelFactory(this, intent.extras)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_link)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.addLinkCancel.setOnClickListener {
            finish()
        }

        binding.addLinkDone.setOnClickListener {
            viewModel.updateLink()
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.finish.collect {
                        if (it) {
                            finish()
                        }
                    }
                }
            }
        }

    }
}