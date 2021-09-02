package com.applsh1205.linkstore.edit_link

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.applsh1205.linkstore.R
import com.applsh1205.linkstore.databinding.ActivityEditLinkBinding

class EditLinkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditLinkBinding

    private lateinit var id: String

    private val viewModel: EditLinkViewModel by viewModels {
        EditLinkViewModelFactory(id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = intent.getStringExtra("id")

        if (id == null) {
            finish()
            return
        }

        this.id = id

        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_link)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.addLinkCancel.setOnClickListener {
            finish()
        }

        binding.addLinkDone.setOnClickListener {
            viewModel.updateLink()
        }

        viewModel.finish.observe(this) {
            if (it) {
                finish()
            }
        }

    }
}