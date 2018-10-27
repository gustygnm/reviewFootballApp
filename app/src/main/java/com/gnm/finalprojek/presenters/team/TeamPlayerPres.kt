package com.gnm.finalprojek.presenters.team

import android.util.Log
import com.gnm.finalprojek.api.ApiReqObject
import com.gnm.finalprojek.api.ApiRequest
import com.gnm.finalprojek.data.models.response.PlayerResponses
import com.gnm.finalprojek.views.teams.TeamPlayersView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamPlayerPres(val view: TeamPlayersView, val request: ApiRequest, val gson: Gson) {
    fun getPlayers(id: String) {
        view.LoadingData()
        doAsync {
            val data = gson.fromJson(request.SendingReq(ApiReqObject.getPlayer(id)), PlayerResponses::class.java)
            Log.d("data player", data.player.size.toString())
            uiThread {
                view.EndLoad()
                view.ShowData(data.player)
            }
        }

    }
}