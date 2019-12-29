package com.alkadev.alkachat

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
    companion object {
         fun launchIntent(context: Context){
            val intent = Intent(context, Home::class.java)
            context.startActivity(intent)
        }
    }
}
