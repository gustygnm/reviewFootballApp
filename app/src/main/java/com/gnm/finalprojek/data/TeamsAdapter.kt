package com.gnm.finalprojek.data

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gnm.finalprojek.data.models.Teams
import  android.view.View
import com.gnm.finalprojek.R
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.teams_list.*

class TeamsAdapter(val context: Context, val dataTeam: List<Teams>, val listener: (Teams) -> Unit) : RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.teams_list, p0, false))
    }

    override fun getItemCount(): Int {
        return dataTeam.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.binding(dataTeam[p1], listener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun binding(teams: Teams, listen: (Teams) -> Unit) {
            //binding
            Picasso.get().load(teams.strTeamBadge).into(imageTeam)
            teamsName.text = teams.strTeam
            itemView.setOnClickListener { listen(teams) }
        }
    }
}