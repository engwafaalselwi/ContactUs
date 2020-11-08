package com.example.contactus

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
   private lateinit var textMessage : TextView
    private lateinit var buttonMessage : Button
    private lateinit var buttonEmail : Button
    private lateinit var buttonMap :Button
    private lateinit var buttonGitHub:Button
    private lateinit var buttonCall : Button
    private lateinit var buttonAdd:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        buttonMessage = findViewById(R.id.buttonMessage1)
        buttonMessage.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                // putExtra(Intent.EXTRA_TEXT, textMessage)
                type = "text/plain"
            }
            if (sendIntent.resolveActivity(packageManager) != null) {
                startActivity(sendIntent)
            }

        }

        buttonEmail = findViewById(R.id.buttonEmail)
        buttonEmail.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("jon@example.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Email subject")
                putExtra(Intent.EXTRA_TEXT, "Email message text")
                type = "text/plain"
            }
            if (sendIntent.resolveActivity(packageManager) != null) {
                startActivity(sendIntent)
            }
        }
        buttonGitHub = findViewById(R.id.buttonGitHub)
        buttonGitHub.setOnClickListener {
            val webIntent = Intent().apply {
                action =Intent.ACTION_VIEW
                data = Uri.parse("https://github.com/engwafaalselwi")
            }
            if (webIntent.resolveActivity(packageManager) != null) {
                startActivity(webIntent)
            }
        }

        buttonMap = findViewById(R.id.buttonMap)
        buttonMap.setOnClickListener {
            val locIntent = Intent().apply {
                action =Intent.ACTION_VIEW
                data = Uri.parse("geo:50.2,40.8")
            }
            if (locIntent.resolveActivity(packageManager) != null) {
                startActivity(locIntent)
            }
        }

        buttonCall = findViewById(R.id.buttonCall)
        buttonCall.setOnClickListener {
            val webIntent = Intent().apply {
                action =Intent.ACTION_DIAL
                data = Uri.parse("tel:7777777")
            }
            if (webIntent.resolveActivity(packageManager) != null) {
                startActivity(webIntent)
            }
        }




    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}