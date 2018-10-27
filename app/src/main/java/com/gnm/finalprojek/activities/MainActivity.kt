package com.gnm.finalprojek.activities

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.annotation.RequiresApi
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.gnm.finalprojek.R
import com.gnm.finalprojek.fragments.FavFrag
import com.gnm.finalprojek.fragments.MatchFrag
import com.gnm.finalprojek.fragments.TeamsFrag
import com.gnm.finalprojek.views.MainActivityView

class MainActivity : AppCompatActivity(), MainActivityView {
    lateinit var navigate: BottomNavigationView
    internal var doubleBackToExit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        navigate.setOnNavigationItemSelectedListener {
            if (it.itemId == R.id.matchMenu) {
                replaceFrag(MatchFrag())
            } else if (it.itemId == R.id.teamsMenu) {
                replaceFrag(TeamsFrag())
                Log.d("tag1", "teams menu")
            } else if (it.itemId == R.id.favMenu) {
                replaceFrag(FavFrag())
                Log.d("tag1", "fav menu")
            }
            true
        }
        navigate.selectedItemId = R.id.matchMenu
    }

    override fun init() {
        navigate =findViewById(R.id.navigate)
    }

    fun replaceFrag(frag: Fragment) {
        val trans = supportFragmentManager.beginTransaction()
        trans.replace(R.id.deploy, frag)
        trans.addToBackStack(null)
        trans.commit()
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onBackPressed() {
        if (doubleBackToExit) {
            finishAffinity()
        } else {
            Toast.makeText(this, R.string.pesan_keluar, Toast.LENGTH_SHORT).show()
        }
        val timee = 2000
        this.doubleBackToExit = true
        Handler().postDelayed({ doubleBackToExit = false }, timee.toLong())
    }

}
