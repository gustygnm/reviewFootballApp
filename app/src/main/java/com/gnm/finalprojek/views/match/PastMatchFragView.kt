package com.gnm.finalprojek.views.match

import com.gnm.finalprojek.data.models.Event

interface PastMatchFragView {
    fun Loading()
    fun FinishLoad()
    fun showData(data: List<Event>)
}