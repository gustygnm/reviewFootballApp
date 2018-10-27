package com.gnm.finalprojek.views

import com.gnm.finalprojek.data.models.Teams

interface TeamsView {
    fun Loading()
    fun LoadingFinish()
    fun ShowData(data: List<Teams>)
    fun init()
}