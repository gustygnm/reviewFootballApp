package com.gnm.finalprojek.data

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gnm.finalprojek.data.models.Event
import android.view.View
import com.gnm.finalprojek.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.event_list.*

class EventAdapter(val context: Context, val data: List<Event>, val listener: (Event) -> Unit) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.event_list, p0, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.binding(data[p1], listener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun binding(event: Event, listen: (Event) -> Unit) {
            dateEvent.text = event.dateEvent
            titleEvent.text = event.strEvent
            homeScore.text = event.intHomeScore
            awayScore.text = event.intAwayScore
            itemView.setOnClickListener { listen(event) }
        }
    }
}