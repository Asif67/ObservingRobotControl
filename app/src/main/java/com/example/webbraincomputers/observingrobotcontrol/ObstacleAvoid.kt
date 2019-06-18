package com.example.webbraincomputers.observingrobotcontrol

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.webkit.WebView


import kotlinx.android.synthetic.main.activity_obstacle_avoid.*





class ObstacleAvoid : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obstacle_avoid)

       // oaWebView.loadUrl("http://192.168.43.23:8000")
        editTextIPoa.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                val sb = StringBuilder();
                val URL = sb.append(editTextIPoa.text).append(":8000").toString();
                oaWebView.settings.javaScriptEnabled = true
                oaWebView.settings.loadsImagesAutomatically = true
                oaWebView.settings.setAppCacheEnabled(true) // Disable while debugging
                oaWebView.loadUrl(URL)
            }
        })



    }
}
