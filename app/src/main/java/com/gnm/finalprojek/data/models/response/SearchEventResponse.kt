package com.gnm.finalprojek.data.models.response

import com.gnm.finalprojek.data.models.Event

data class SearchEventResponse(
        val event: List<Event>
)