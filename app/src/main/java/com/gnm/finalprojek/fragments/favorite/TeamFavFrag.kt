package com.gnm.finalprojek.fragments.favorite

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gnm.finalprojek.R
import com.gnm.finalprojek.activities.TeamDetail
import com.gnm.finalprojek.data.sqlite.*
import com.gnm.finalprojek.views.favourite.TeamFavView
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.uiThread

class TeamFavFrag : Fragment(), TeamFavView {

    lateinit var recyclerView: RecyclerView
    var dataBookmark: MutableList<BookmarkTeam> = mutableListOf()
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var adapter: BookTeamAdapter
    lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.team_fav, container, false)
        init()
        return rootView
    }

    override fun ShowData() {
        LoadData()
        doAsync {
            context?.database?.use {
                val res = select(BookmarkTeam.TABLE)
                val bookmark = res.parseList(classParser<BookmarkTeam>())

                uiThread {
                    FinishLoadData()
                    dataBookmark.clear()
                    dataBookmark.addAll(bookmark)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun init() {
        swipeRefreshLayout = rootView.findViewById(R.id.swiping)
        recyclerView = rootView.findViewById(R.id.recTeamFav)
        val linMan = LinearLayoutManager(this.context)
        linMan.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linMan
        ShowData()
        adapter = BookTeamAdapter(this.context!!, dataBookmark) {
            TeamDetail.caller = "fav"
            val intent = Intent(this.context, TeamDetail::class.java)
            intent.putExtra("data", it)
            startActivity(intent)
        }
        swipeRefreshLayout.onRefresh {
            ShowData()
        }
        recyclerView.adapter = adapter
    }

    override fun LoadData() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun FinishLoadData() {
        swipeRefreshLayout.isRefreshing = false
    }
}