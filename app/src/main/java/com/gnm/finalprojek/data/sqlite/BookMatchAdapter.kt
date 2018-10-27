package com.gnm.finalprojek.data.sqlite

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gnm.finalprojek.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.event_list.*

class BookMatchAdapter(val context: Context, val data: List<BookmarkMatch>, val listener: (BookmarkMatch) -> Unit) : RecyclerView.Adapter<BookMatchAdapter.Holder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        return Holder(LayoutInflater.from(context).inflate(R.layout.event_list, p0, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        p0.binding(data[p1], listener)
    }

    class Holder(override val containerView: View?) : RecyclerView.ViewHolder(containerView!!), LayoutContainer {
        fun binding(bookmark: BookmarkMatch, listen: (BookmarkMatch) -> Unit) {
            dateEvent.text = bookmark.dateEvent
            titleEvent.text = "${bookmark.home} vs ${bookmark.away}"
            homeScore.text = bookmark.homeScore
            awayScore.text = bookmark.awayScore
            itemView.setOnClickListener { listen(bookmark) }
        }
    }
}