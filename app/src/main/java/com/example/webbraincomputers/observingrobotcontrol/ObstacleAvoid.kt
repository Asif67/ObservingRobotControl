package com.example.webbraincomputers.observingrobotcontrol

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.webkit.WebView
import android.widget.Button
import com.jcraft.jsch.ChannelExec
import com.jcraft.jsch.JSch
import kotlinx.android.synthetic.main.activity_obstacle_avoid.*
import java.io.ByteArrayOutputStream
import java.util.*


class ObstacleAvoid : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obstacle_avoid)
        val Load: Button = findViewById(R.id.oabtnLoad)
        Load.setOnClickListener {

            val sb = StringBuilder();
            val URL = sb.append("http://").append(editTextIPoa.text).append(":8000").toString();
            oaWebView.settings.javaScriptEnabled = true
            oaWebView.settings.loadsImagesAutomatically = true
            oaWebView.settings.setAppCacheEnabled(true) // Disable while debugging
            SshTaskOAon(editTextIPoa.text).execute()
            SshTaskCon(editTextIPoa.text).execute()
            oaWebView.loadUrl(URL)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        SshTaskOAoff(editTextIPoa.text).execute()
        SshTaskCoff(editTextIPoa.text).execute()
    }
    class SshTaskOAon(private val url: Editable) : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg p0: Void?): String {
            val output = executeRemoteCommandOAon("pi", "raspberry", url.toString())
            print(output)
            return output
        }
    }
    class SshTaskOAoff(private val url: Editable) : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg p0: Void?): String {
            val output = executeRemoteCommandOAoff("pi", "raspberry", url.toString())
            print(output)
            return output
        }
    }
    class SshTaskCon(private val url: Editable) : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg p0: Void?): String {
            val output = executeRemoteCommandCon("pi", "raspberry", url.toString())
            print(output)
            return output
        }
    }
    class SshTaskCoff(private val url: Editable) : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg p0: Void?): String {
            val output = executeRemoteCommandCoff("pi", "raspberry", url.toString())
            print(output)
            return output
        }
    }
}

fun executeRemoteCommandOAon(username: String,
                         password: String,
                         hostname: String,
                         port: Int = 22): String {
    val jsch = JSch()
    val session = jsch.getSession(username, hostname, port)
    session.setPassword(password)

    // Avoid asking for key confirmation.
    val properties = Properties()
    properties.put("StrictHostKeyChecking", "no")
    session.setConfig(properties)

    session.connect()

    // Create SSH Channel.
    val sshChannel = session.openChannel("exec") as ChannelExec
    val outputStream = ByteArrayOutputStream()
    sshChannel.outputStream = outputStream

    // Execute command.
    //sshChannel.setCommand("sudo python /home/pi/Desktop/ActualProject/MainScript.py")
    sshChannel.setCommand("sudo python /home/pi/Desktop/ActualProject/MainScriptWithMotor.py")
    sshChannel.connect()
    // Sleep needed in order to wait long enough to get result back.
    Thread.sleep(1_000)
    sshChannel.disconnect()

    session.disconnect()
    return outputStream.toString()

}

fun executeRemoteCommandOAoff(username: String,
                         password: String,
                         hostname: String,
                         port: Int = 22): String {
    val jsch = JSch()
    val session = jsch.getSession(username, hostname, port)
    session.setPassword(password)

    // Avoid asking for key confirmation.
    val properties = Properties()
    properties.put("StrictHostKeyChecking", "no")
    session.setConfig(properties)

    session.connect()

    // Create SSH Channel.
    val sshChannel = session.openChannel("exec") as ChannelExec
    val outputStream = ByteArrayOutputStream()
    sshChannel.outputStream = outputStream

    // Execute command.
    //sshChannel.setCommand("sudo pkill -f MainScript.py")
    sshChannel.setCommand("sudo pkill -f MainScriptWithMotor.py")
    sshChannel.connect()
    Thread.sleep(1_000)
    sshChannel.disconnect()

    session.disconnect()
    return outputStream.toString()

}

fun executeRemoteCommandCon(username: String,
                             password: String,
                             hostname: String,
                             port: Int = 22): String {
    val jsch = JSch()
    val session = jsch.getSession(username, hostname, port)
    session.setPassword(password)

    // Avoid asking for key confirmation.
    val properties = Properties()
    properties.put("StrictHostKeyChecking", "no")
    session.setConfig(properties)

    session.connect()

    // Create SSH Channel.
    val sshChannel = session.openChannel("exec") as ChannelExec
    val outputStream = ByteArrayOutputStream()
    sshChannel.outputStream = outputStream

    // Execute command.
    sshChannel.setCommand("sudo python3 /home/pi/Desktop/C.py")
    sshChannel.connect()
    Thread.sleep(1_000)
    sshChannel.disconnect()

    session.disconnect()

    return outputStream.toString()

}

fun executeRemoteCommandCoff(username: String,
                              password: String,
                              hostname: String,
                              port: Int = 22): String {
    val jsch = JSch()
    val session = jsch.getSession(username, hostname, port)
    session.setPassword(password)

    // Avoid asking for key confirmation.
    val properties = Properties()
    properties.put("StrictHostKeyChecking", "no")
    session.setConfig(properties)

    session.connect()

    // Create SSH Channel.
    val sshChannel = session.openChannel("exec") as ChannelExec
    val outputStream = ByteArrayOutputStream()
    sshChannel.outputStream = outputStream

    // Execute command.
    sshChannel.setCommand("sudo pkill -f C.py")
    sshChannel.connect()
    // Sleep needed in order to wait long enough to get result back.
    Thread.sleep(1_000)
    sshChannel.disconnect()

    session.disconnect()
    return outputStream.toString()

}
