package com.gnm.finalprojek.data

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gnm.finalprojek.R
import com.gnm.finalprojek.data.models.Players
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.player_list.*

class PlayersAdapter(val context: Context, val data: List<Players>, val listener: (Players) -> Unit) : RecyclerView.Adapter<PlayersAdapter.ViewHold>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHold {
        return ViewHold(LayoutInflater.from(context).inflate(R.layout.player_list, p0, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: ViewHold, p1: Int) {
        p0.BindItem(data[p1], listener)
    }

    class ViewHold(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun BindItem(player: Players, listen: (Players) -> Unit) {
            Picasso.get().load(player.strCutout).into(playerImage)
            playerName.text = player.strPlayer
            itemView.setOnClickListener { listen(player) }
        }

    }
}