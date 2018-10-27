package com.gnm.finalprojek.views.teams

import com.gnm.finalprojek.data.models.Players

interface TeamPlayersView {
    fun LoadingData()
    fun EndLoad()
    fun ShowData(data: List<Players>)
    fun init()
}