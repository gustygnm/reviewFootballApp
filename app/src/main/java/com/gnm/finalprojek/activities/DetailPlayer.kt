package com.gnm.finalprojek.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.gnm.finalprojek.R
import com.gnm.finalprojek.data.models.Players
import com.gnm.finalprojek.views.PlayerActivityView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_player.*

class DetailPlayer : AppCompatActivity(), PlayerActivityView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_player)
        init()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun init() {
        val data = intent.extras.getParcelable("playerData") as Players
        LoadImage(data.strCutout.toString())
        Log.d("data", data.idPlayer)
        supportActionBar!!.title = data.strPlayer
        playerDesc.text = data.strDescriptionEN
        playerHeight.text = "Height (m) : ${data.strHeight}"
        playerWeight.text = "Weight (Kg) : ${data.strWeight}"
    }

    override fun LoadImage(url: String) {
        Picasso.get().load(url).into(playerBanner)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}
