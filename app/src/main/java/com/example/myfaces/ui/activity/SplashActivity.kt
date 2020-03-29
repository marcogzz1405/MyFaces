package com.example.myfaces.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.myfaces.MainActivity
import com.example.myfaces.R

class SplashActivity : AppCompatActivity() {

    private var handler = Handler()
    private var runnable: Runnable? = null

    var bundle : Bundle? = null
    var topic = "MyFacesApp"

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initApp()
    }

    private fun initApp() {
        runnable = Runnable {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        handler.postDelayed(runnable, 3000)
    }

    override fun onPause() {
        super.onPause()
        if(runnable != null){
            handler.removeCallbacks(runnable)
        }
    }
}
