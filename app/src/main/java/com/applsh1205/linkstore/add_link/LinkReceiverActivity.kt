package com.applsh1205.linkstore.add_link

import android.content.Intent
import android.os.Bundle
import android.webkit.URLUtil
import androidx.appcompat.app.AppCompatActivity

class LinkReceiverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (intent.action == Intent.ACTION_SEND) {
            val url = intent.getStringExtra(Intent.EXTRA_TEXT)
            if (URLUtil.isValidUrl(url)) {
                val intent = Intent(this, AddLinkActivity::class.java)
                intent.putExtra("url", url)
                startActivity(intent)
            }
        }

        finish()
    }
}