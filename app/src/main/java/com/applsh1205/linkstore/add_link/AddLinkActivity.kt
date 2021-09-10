package com.applsh1205.linkstore.add_link

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.applsh1205.linkstore.R
import com.applsh1205.linkstore.databinding.ActivityAddLinkBinding

class AddLinkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddLinkBinding

    private val viewModel: AddLinkViewModel by viewModels()

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

        viewModel.finish.observe(this) {
            if (it) {
                finish()
            }
        }

    }
}