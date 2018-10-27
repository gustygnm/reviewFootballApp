package com.gnm.finalprojek.api

object ApiReqObject {
    fun PastMatchReq(league: String): String {
        return "https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=$league"
    }

    fun NextMatchReq(league: String): String {
        return "https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=$league"
    }

    fun searchEvent(param: String): String {
        return "https://www.thesportsdb.com/api/v1/json/1/searchevents.php?e=$param"
    }

    fun SearchTeamUrl(param: String): String {
        return "https://www.thesportsdb.com/api/v1/json/1/searchteams.php?t=$param"
    }

    fun LigaReq(): String {
        return ""
    }

    fun TeamsDetailReq(id: String): String {
        return "https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=$id"
    }

    fun TeamsReq(league: String): String {
        return "https://www.thesportsdb.com/api/v1/json/1/lookup_all_teams.php?id=$league"
    }

    fun getDetailMatch(id: String): String {
        return "https://www.thesportsdb.com/api/v1/json/1/lookupevent.php?id=$id"
    }

    fun getPlayer(id: String): String {
        return "https://www.thesportsdb.com/api/v1/json/1/lookup_all_players.php?id=$id"
    }
}