package com.grafxstudio.grafx_studio.network

import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface GrafxApi {
    @GET("all-logos.json")
    suspend fun test() : List<Any>
}