package com.sanstech.sanstechtask.ui.mainPage

import android.os.Bundle
import android.util.Log
import com.sanstech.sanstechtask.R
import com.sanstech.sanstechtask.databinding.ActivityMainBinding
import com.sanstech.sanstechtask.ui.BaseActivity
import com.sanstech.sanstechtask.ui.mainPage.view.ScoreListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    //region lifecycle
    override fun getViewBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        val fragment = ScoreListFragment()
        transaction.add(R.id.fragmentContainerView, fragment)
        transaction.commit()
    }
    //endregion


}