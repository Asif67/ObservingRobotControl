package com.example.webbraincomputers.observingrobotcontrol

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ManualControl:Button = findViewById(R.id.btn_ManualControl)
        val LineFollow:Button = findViewById(R.id.btn_LineFollowingMode)
        val ObstacleAvoid:Button = findViewById(R.id.btn_ObstacleAvoding)
        val Exit:Button = findViewById(R.id.btn_Exit)
        ManualControl.setOnClickListener {
            val Intent = Intent(this,com.example.webbraincomputers.observingrobotcontrol.ManualControl::class.java    )
            startActivity(Intent)
        }
        LineFollow.setOnClickListener {
            val Intent = Intent(this,com.example.webbraincomputers.observingrobotcontrol.LineFollow::class.java    )
            startActivity(Intent)
        }
        ObstacleAvoid.setOnClickListener {
            val Intent = Intent(this,com.example.webbraincomputers.observingrobotcontrol.ObstacleAvoid::class.java    )
            startActivity(Intent)
        }
        Exit.setOnClickListener {
            finish()
            System.exit(0)
        }
    }

}
