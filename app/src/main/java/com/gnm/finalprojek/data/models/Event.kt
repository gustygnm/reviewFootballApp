package com.gnm.finalprojek.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(
        @SerializedName("idEvent")
        val idEvent: String? = "",
        val idSoccerXML: String? = "",
        @SerializedName("strEvent")
        val strEvent: String? = "",
        val strFilename: String? = "",
        val strSport: String? = "",
        val idLeague: String? = "",
        val strLeague: String? = "",
        val strSeason: String? = "",
        val strDescriptionEN: String? = "",
        @SerializedName("strHomeTeam")
        val strHomeTeam: String? = "",
        @SerializedName("strAwayTeam")
        val strAwayTeam: String? = "",
        val intHomeScore: String? = "",
        val intRound: String? = "",
        val intAwayScore: String? = "",
        val intSpectators: String? = "",
        val strHomeGoalDetails: String? = "",
        val strHomeRedCards: String? = "",
        val strHomeYellowCards: String? = "",
        val strHomeLineupGoalkeeper: String? = "",
        val strHomeLineupDefense: String? = "",
        val strHomeLineupMidfield: String? = "",
        val strHomeLineupForward: String? = "",
        val strHomeLineupSubstitutes: String? = "",
        val strHomeFormation: String? = "",
        val strAwayRedCards: String? = "",
        val strAwayYellowCards: String? = "",
        val strAwayGoalDetails: String? = "",
        val strAwayLineupGoalkeeper: String? = "",
        val strAwayLineupDefense: String? = "",
        val strAwayLineupMidfield: String? = "",
        val strAwayLineupForward: String? = "",
        val strAwayLineupSubstitutes: String? = "",
        val strAwayFormation: String? = "",
        val intHomeShots: String? = "",
        val intAwayShots: String? = "",
        val dateEvent: String? = "",
        @SerializedName("strDate")
        val strDate: String? = "",
        val strTime: String? = "",
        val idHomeTeam: String? = "",
        val idAwayTeam: String? = "",
        val strLocked: String? = ""
) : Parcelable