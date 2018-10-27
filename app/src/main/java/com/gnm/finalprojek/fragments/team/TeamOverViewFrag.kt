package com.gnm.finalprojek.fragments.team

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.gnm.finalprojek.R
import com.gnm.finalprojek.views.teams.TeamOverviewView

class TeamOverViewFrag : Fragment(), TeamOverviewView {

    lateinit var textDescipt: TextView
    lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.team_overview, container, false)
        init()
        return rootView
    }

    override fun init() {
        textDescipt = rootView.findViewById(R.id.overText)
        Log.d("teams Descript in frag", teamDesciption)
        textDescipt.text = teamDesciption
    }

    override fun LoadingData() {

    }

    override fun EndLoad() {

    }

    override fun ShowData() {

    }

    companion object {
        var teamDesciption: String = ""
    }

}