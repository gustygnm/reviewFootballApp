package com.gnm.finalprojek.presenters

import android.util.Log
import com.gnm.finalprojek.api.ApiReqObject
import com.gnm.finalprojek.api.ApiRequest
import com.gnm.finalprojek.data.models.response.EventResponse
import com.gnm.finalprojek.data.models.response.TeamsResponse
import com.gnm.finalprojek.views.SearchView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class SearchPres(val view: SearchView, val request: ApiRequest, val gson: Gson) {
    fun SearchTeam(name: String) {
        view.LoadingData()
        doAsync {
            val data = gson.fromJson(request.SendingReq(ApiReqObject.SearchTeamUrl(name)), TeamsResponse::class.java)
            Log.d("search team length", data.teams.size.toString())
            uiThread {
                view.FinsihLoading()
                view.ShowDataTeam(data.teams)
            }
        }
    }
}