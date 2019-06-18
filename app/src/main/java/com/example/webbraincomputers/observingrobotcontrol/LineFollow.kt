package com.example.webbraincomputers.observingrobotcontrol

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_line_follow.*
import kotlinx.android.synthetic.main.activity_obstacle_avoid.*

class LineFollow : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_follow)

        //lfWebView.loadUrl("http://192.168.1.47:8000")
        editTextIPlf.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                val sb = StringBuilder();
                val URL = sb.append(editTextIPlf.text).append(":8000").toString();
                lfWebView.settings.javaScriptEnabled = true
                lfWebView.settings.loadsImagesAutomatically = true
                lfWebView.settings.setAppCacheEnabled(true) // Disable while debugging
                lfWebView.loadUrl(URL)
            }
        })
    }
}
