package com.gnm.finalprojek.data.models.response

import com.gnm.finalprojek.data.models.Event

import com.google.gson.annotations.SerializedName

data class EventResponse(
        @SerializedName("events")
        val events: List<Event>)