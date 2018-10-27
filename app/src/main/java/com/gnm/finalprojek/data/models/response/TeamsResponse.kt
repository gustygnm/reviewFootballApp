package com.gnm.finalprojek.data.models.response

import com.gnm.finalprojek.data.models.Teams
import com.google.gson.annotations.SerializedName

data class TeamsResponse(
        @SerializedName("teams")
        val teams: List<Teams>
)