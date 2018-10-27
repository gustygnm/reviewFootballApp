package com.gnm.finalprojek.data.sqlite

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookmarkMatch(val id: Int, val idEvent: String, val homeId: String,
                         val awayId: String, val home: String,
                         val away: String, val awayScore: String,
                         val dateEvent: String, val homeScore: String) : Parcelable {
    companion object {
        const val TABLE: String = "TB_BOOKMARK"
        const val EVENT_ID: String = "EventId"
        const val HOME_ID: String = "homeId"
        const val AWAY_ID: String = "awayID"
        const val HOME: String = "home"
        const val AWAY: String = "away"
        const val DATE: String = "date"
        const val HOME_SCORE: String = "homeScore"
        const val AWAY_SCORE: String = "awayScore"
    }
}