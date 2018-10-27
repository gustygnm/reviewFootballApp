package com.gnm.finalprojek.presenters.team

import com.gnm.finalprojek.api.ApiReqObject
import com.gnm.finalprojek.api.ApiRequest
import com.gnm.finalprojek.data.models.response.TeamsResponse
import com.gnm.finalprojek.views.TeamsView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamPresenter(val view: TeamsView, val request: ApiRequest, val gson: Gson) {
    fun getTeam(liga: String) {
        view.Loading()
        doAsync {
            val data = gson.fromJson(request.SendingReq(ApiReqObject.TeamsReq(liga)), TeamsResponse::class.java)
            //Log.d("Data json",data.teams.toString())
            uiThread {
                view.LoadingFinish()
                view.ShowData(data.teams)
            }
        }
    }
}