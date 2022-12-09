package com.gabrielrf.proyecto.model.server

import com.gabrielrf.proyecto.model.Team

data class RemoteResult(
    val errors: List<Any>,
    val `get`: String,
    val parameters: List<Any>,
    val response: List<Team>,
    val results: Int
)

