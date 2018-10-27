package com.gnm.finalprojek.data.sqlite

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookmarkTeam(val id: Int, val TeamId: String, val TeamName: String,
                        val TeamDesc: String, val TeamBadge: String,
                        val TeamStadium: String, val TeamYear: String) : Parcelable {
    companion object {
        const val TABLE: String = "TB_TEAMS"
        const val TEAM_ID: String = "TeamsID"
        const val TEAM_NAME: String = "TeamsName"
        const val TEAM_DESC: String = "TeamsDesc"
        const val TEAM_BADGE: String = "TeamPic"
        const val TEAM_STADIUM: String = "TeamStadium"
        const val TEAM_YEAR: String = "TeamYear"
    }
}