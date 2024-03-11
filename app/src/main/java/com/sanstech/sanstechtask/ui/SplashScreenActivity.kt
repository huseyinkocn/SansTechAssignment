package com.sanstech.sanstechtask.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatDelegate
import com.sanstech.sanstechtask.databinding.ActivitySplashScreenBinding
import com.sanstech.sanstechtask.ui.mainPage.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenActivity : BaseActivity<ActivitySplashScreenBinding>() {

    override fun getViewBinding(): ActivitySplashScreenBinding =
        ActivitySplashScreenBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) // Uygulamanın karanlık modda değişmesini engelliyoruz
        init()
        rout()
    }

    //region init
    private fun init() {
        currentContext = this
    }

    private fun rout() {
        Handler(Looper.getMainLooper()).postDelayed({
            intent(MainActivity::class.java)
            finish()
        }, 1500)
    }
    //endregion
}
