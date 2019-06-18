package com.example.webbraincomputers.observingrobotcontrol

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_manual_control.*
import kotlinx.android.synthetic.main.activity_obstacle_avoid.*

class ManualControl : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_control)

        //mcWebView.loadUrl("http://192.168.1.47:8000")
        editTextIPmc.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                val sb = StringBuilder();
                val URL = sb.append(editTextIPmc.text).append(":8000").toString();
                mcWebView.settings.javaScriptEnabled = true
                mcWebView.settings.loadsImagesAutomatically = true
                mcWebView.settings.setAppCacheEnabled(true) // Disable while debugging
                mcWebView.loadUrl(URL)
            }
        })
    }
}
