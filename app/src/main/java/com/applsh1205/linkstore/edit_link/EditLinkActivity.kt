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
import com.applsh1205.linkstore.inject.SavedStateViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class EditLinkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditLinkBinding

    @Inject
    lateinit var savedStateViewModelFactory: SavedStateViewModelFactory

    private val viewModel: EditLinkViewModel by viewModels { savedStateViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_link)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.editLinkCancel.setOnClickListener {
            finish()
        }

        binding.editLinkDone.setOnClickListener {
            viewModel.updateLink()
        }

        binding.editLinkDelete.setOnClickListener {
            viewModel.deleteLink()
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