package com.csci448.ebergo.scavenger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.Toolbar

import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp

import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.csci448.ebergo.scavenger2.R.id.nav_host_fragment_container
import com.csci448.ebergo.scavenger2.ui.ui.detail_listing.DetailListingFragment
import com.csci448.ebergo.scavenger2.ui.ui.keyword_list.KeywordListFragment
import com.csci448.ebergo.scavenger2.ui.ui.listing_list.ListingListFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

private const val LogTag = "448.MainActivity"
class MainActivity : AppCompatActivity() {//, KeywordListFragment.Callbacks, ListingListFragment.Callbacks {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        navController = findNavController(R.id.nav_host_fragment)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_home, R.id.nav_favorite, R.id.nav_search_settings), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_options_bar, menu)
        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }/*
    override fun onAggKeywordSelected(keyword: String) {
        Log.d(LogTag,"onAggKeywordsSelected")
        //navController.navigate(R.id.fragment)
        val fragment = ListingListFragment.newInstance(keyword)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onListingListSelected(ListingID: UUID) {
        Log.d(LogTag,"onListingListsSelected")
        val fragment = DetailListingFragment.newInstance(ListingID)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .addToBackStack(null)
            .commit()
    }
    */
}
