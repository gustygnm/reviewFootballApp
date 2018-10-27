package com.gnm.finalprojek.fragments.team

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
import com.gnm.finalprojek.activities.DetailPlayer
import com.gnm.finalprojek.api.ApiRequest
import com.gnm.finalprojek.data.PlayersAdapter
import com.gnm.finalprojek.data.models.Players
import com.gnm.finalprojek.presenters.team.TeamPlayerPres
import com.gnm.finalprojek.views.teams.TeamPlayersView
import com.google.gson.Gson
import org.jetbrains.anko.support.v4.onRefresh

class TeamPlayersFrag : Fragment(), TeamPlayersView {

    lateinit var presenter: TeamPlayerPres
    lateinit var adapter: PlayersAdapter
    var dataPlayer: MutableList<Players> = mutableListOf()
    lateinit var rootView: View
    lateinit var recyclerView: RecyclerView
    lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.team_players, container, false)
        return rootView
    }

    override fun LoadingData() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun EndLoad() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun ShowData(data: List<Players>) {
        dataPlayer.clear()
        dataPlayer.addAll(data)
        adapter.notifyDataSetChanged()
    }

    override fun init() {
        recyclerView = rootView.findViewById(R.id.recPlay)
        swipeRefreshLayout = rootView.findViewById(R.id.swipingPlayer)
        val request = ApiRequest()
        val gson = Gson()
        presenter = TeamPlayerPres(this, request, gson)
        presenter.getPlayers(idTeams)
        val layMan = LinearLayoutManager(this.context)
        layMan.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layMan
        adapter = PlayersAdapter(this.context!!, dataPlayer) {
            val intent = Intent(this.context, DetailPlayer::class.java)
            intent.putExtra("playerData", it)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        swipeRefreshLayout.onRefresh {
            presenter.getPlayers(idTeams)
        }
    }

    companion object {
        var idTeams: String = ""
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }
}