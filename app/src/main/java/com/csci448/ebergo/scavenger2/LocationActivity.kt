package com.csci448.ebergo.scavenger2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
private const val LogTag = "448.LocationActivity"
class LocationActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.listing_detail_view)
    }
    companion object {
        fun createIntent(packageContext: Context?): Intent {
            return Intent(packageContext,LocationActivity::class.java)
        }
    }
    override fun onStart()
    {
        super.onStart()
        Log.d(LogTag,"OnStart Called")
    }
    override fun onResume()
    {
        super.onResume()
        Log.d(LogTag,"OnResume called")
    }

    override fun onPause() {
        Log.d(LogTag,"onPause Called")
        super.onPause()
    }

    override fun onStop() {
        Log.d(LogTag,"onStop Called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(LogTag,"onDestroy Called")
        super.onDestroy()
    }
}