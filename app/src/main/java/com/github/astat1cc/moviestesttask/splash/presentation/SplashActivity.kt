package com.github.astat1cc.moviestesttask.splash.presentation

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import com.github.astat1cc.moviestesttask.R
import com.github.astat1cc.moviestesttask.movie_list.presentation.MovieListActivity
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onStart() {
        super.onStart()

        lifecycleScope.launchWhenStarted {
            delay(1200L)
            val intent = Intent(this@SplashActivity, MovieListActivity::class.java)
            if (this@SplashActivity.lifecycle.currentState == Lifecycle.State.RESUMED) {
                startActivity(intent)
                finish()
            }
        }
    }
}