package com.gabrielrf.proyecto.model.server

import com.gabrielrf.proyecto.model.Meta
import com.gabrielrf.proyecto.model.TeamsRes
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RemoteService {
    @Headers("x-rapidapi-key: b0ddfe07dbmsh6daab3b699a1969p16482djsnc2b19a757cd4")
    @GET("teams")
    suspend fun getTeams(): TeamsRes
}