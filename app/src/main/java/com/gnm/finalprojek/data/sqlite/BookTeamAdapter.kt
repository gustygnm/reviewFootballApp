package com.gnm.finalprojek.data.sqlite

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gnm.finalprojek.R
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.teams_list.*

class BookTeamAdapter(val context: Context, val data: List<BookmarkTeam>, val listener: (BookmarkTeam) -> Unit) : RecyclerView.Adapter<BookTeamAdapter.Holder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        return Holder(LayoutInflater.from(context).inflate(R.layout.teams_list, p0, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        p0.binding(data[p1], listener)
    }

    class Holder(override val containerView: View?) : RecyclerView.ViewHolder(containerView!!), LayoutContainer {
        fun binding(bookmark: BookmarkTeam, listen: (BookmarkTeam) -> Unit) {
            Picasso.get().load(bookmark.TeamBadge).into(imageTeam)
            teamsName.text = bookmark.TeamName
            itemView.setOnClickListener { listen(bookmark) }
        }
    }
}