package com.example.gymgenius

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gymgenius.activity.LoginActivity
import com.example.gymgenius.global.DB
import com.example.gymgenius.manager.SessionManager

class SplashScreenActivity : AppCompatActivity() {
    private var mDelayHandler : Handler?=null
    private val splash_delay :Long = 3000 //3 seconds
    var db:DB?=null
    var session:SessionManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mDelayHandler = Handler()
        mDelayHandler?.postDelayed(mRunnable,splash_delay)
    }

    private val mRunnable : Runnable = kotlinx.coroutines.Runnable {

        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()

    }

}