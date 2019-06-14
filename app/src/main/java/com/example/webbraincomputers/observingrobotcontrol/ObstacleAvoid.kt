package com.example.webbraincomputers.observingrobotcontrol

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_obstacle_avoid.*


class ObstacleAvoid : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obstacle_avoid)

        oaWebView.loadUrl("http://192.168.1.47:8000")


    }
}
