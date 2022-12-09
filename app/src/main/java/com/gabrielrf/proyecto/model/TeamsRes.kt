package com.gabrielrf.proyecto.model

import com.google.gson.annotations.SerializedName

data class TeamsRes(
    @SerializedName("data") val team: List<Team>,
    @SerializedName("meta") val meta: Meta,
)