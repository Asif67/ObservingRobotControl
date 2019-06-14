package com.example.webbraincomputers.observingrobotcontrol

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_line_follow.*
import kotlinx.android.synthetic.main.activity_obstacle_avoid.*

class LineFollow : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_follow)

        lfWebView.loadUrl("http://192.168.1.47:8000")
    }
}
