package com.grafxstudio.grafx_studio.network

import javax.inject.Inject

class GrafxRepo @Inject constructor(private val grafxApi : GrafxApi) {
    suspend fun getAllLogos() : List<Any> = grafxApi.test()
}