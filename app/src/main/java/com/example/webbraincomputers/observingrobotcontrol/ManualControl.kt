package com.example.webbraincomputers.observingrobotcontrol

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_manual_control.*
import kotlinx.android.synthetic.main.activity_obstacle_avoid.*

class ManualControl : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_control)

        mcWebView.loadUrl("http://192.168.1.47:8000")
    }
}
