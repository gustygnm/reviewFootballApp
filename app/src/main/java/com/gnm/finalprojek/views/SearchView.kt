package com.gnm.finalprojek.views

import com.gnm.finalprojek.data.models.Event
import com.gnm.finalprojek.data.models.Teams

interface SearchView {
	fun LoadingData()
	fun FinsihLoading()
	fun ShowDataEvent(data:List<Event>)
	fun ShowDataTeam(data:List<Teams>)
}