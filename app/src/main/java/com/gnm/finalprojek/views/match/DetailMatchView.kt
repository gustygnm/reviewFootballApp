package com.gnm.finalprojek.views.match

import com.gnm.finalprojek.data.models.Event
import com.gnm.finalprojek.data.models.Teams

interface DetailMatchView {
    fun LoadData()
    fun FinishLoad()
    fun ShowData(data: List<Event>)
    fun ShowHomeTeamsData(data: List<Teams>)
    fun ShowAwayTeamsData(data: List<Teams>)
}