package com.gnm.finalprojek.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MenuItem
import com.gnm.finalprojek.R
import com.gnm.finalprojek.api.ApiReqObject
import com.gnm.finalprojek.api.ApiRequest
import com.gnm.finalprojek.data.EventAdapter
import com.gnm.finalprojek.data.TeamsAdapter
import com.gnm.finalprojek.data.models.Event
import com.gnm.finalprojek.data.models.Teams
import com.gnm.finalprojek.data.models.response.SearchEventResponse
import com.gnm.finalprojek.presenters.SearchPres
import com.gnm.finalprojek.views.SearchView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.abc_cascading_menu_item_layout.*
import kotlinx.android.synthetic.main.abc_popup_menu_item_layout.*
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.notification_template_lines_media.view.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.uiThread

class SearchActivity : AppCompatActivity(), SearchView {
    var dataTeam: MutableList<Teams> = mutableListOf()
    var dataEvent: MutableList<Event> = mutableListOf()
    lateinit var adapterTeam: TeamsAdapter
    lateinit var adapterEvent: EventAdapter
    lateinit var presenter: SearchPres

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val request = ApiRequest()
        val gson = Gson()
        presenter = SearchPres(this, request, gson)

        searchEdit?.setOnQueryTextListener(object : android.support.v7.widget.SearchView.OnQueryTextListener, android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if (caller.equals("match")) {
                    adapterEvent = EventAdapter(this@SearchActivity, dataEvent) {
                        DetailMatch.caller = "match"
                        val intent = Intent(this@SearchActivity, DetailMatch::class.java)
                        intent.putExtra("idMatch", it)
                        startActivity(intent)
                    }
                    val linMan = LinearLayoutManager(this@SearchActivity)
                    linMan.orientation = LinearLayoutManager.VERTICAL
                    recSearch.layoutManager = linMan
                    recSearch.adapter = adapterEvent
                    requesting(p0.toString())

                } else if (caller.equals("teams")) {
                    adapterTeam = TeamsAdapter(this@SearchActivity, dataTeam) {
                        TeamDetail.caller = "teams"
                        val intent = Intent(this@SearchActivity, TeamDetail::class.java)
                        intent.putExtra("idTeam", it)
                        startActivity(intent)
                    }
                    val linMan = LinearLayoutManager(this@SearchActivity)
                    linMan.orientation = LinearLayoutManager.VERTICAL
                    recSearch.layoutManager = linMan
                    recSearch.adapter = adapterTeam
                    presenter.SearchTeam(p0.toString())
                }
                return false
            }

        })

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    companion object {
        var caller = ""
    }


    override fun LoadingData() {
        swiping.isRefreshing = true
    }

    override fun FinsihLoading() {
        swiping.isRefreshing = false
    }

    override fun ShowDataEvent(data: List<Event>) {
        dataEvent.clear()
        dataEvent.addAll(data)
        adapterEvent.notifyDataSetChanged()
    }

    override fun ShowDataTeam(data: List<Teams>) {
        dataTeam.clear()
        dataTeam.addAll(data)
        adapterTeam.notifyDataSetChanged()
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

    fun requesting(name: String) {
        val gson = Gson()
        val request = ApiRequest()
        LoadingData()
        doAsync {
            val data = gson.fromJson(request.SendingReq(ApiReqObject.searchEvent(name)), SearchEventResponse::class.java)
            Log.d("Link request ", ApiReqObject.searchEvent(name))
            if (data == null) {
                Log.d("search length", "data is null")
            } else {
                Log.d("search length", data.event.toString())
            }
            uiThread {
                FinsihLoading()
                ShowDataEvent(data.event)
            }
        }
    }
}
