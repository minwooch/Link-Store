package com.applsh1205.linkstore.add_link

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.applsh1205.linkstore.R
import com.applsh1205.linkstore.databinding.ActivityAddLinkBinding

class AddLinkActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddLinkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_link)
        binding.lifecycleOwner = this

    }
}