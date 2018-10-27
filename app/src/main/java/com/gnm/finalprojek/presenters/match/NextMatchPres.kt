package com.gnm.finalprojek.presenters.match

import android.util.Log
import com.gnm.finalprojek.api.ApiReqObject
import com.gnm.finalprojek.api.ApiRequest
import com.gnm.finalprojek.data.models.response.EventResponse
import com.gnm.finalprojek.views.match.NextMatchFragView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NextMatchPres(val view: NextMatchFragView, val request: ApiRequest, val gson: Gson) {
    fun getData(liga: String) {
        view.Loading()
        doAsync {
            val data = gson.fromJson(request.SendingReq(ApiReqObject.NextMatchReq(liga)), EventResponse::class.java)
            Log.d("data ", data.toString())
            uiThread {
                view.FinishLoad()
                view.showData(data.events)
            }
        }
    }
}