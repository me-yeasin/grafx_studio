package com.grafxstudio.grafx_studio.model

data class Item(
    val id : String,
    val title : String,
    val subTitle : String,
    val thumbnailUrl : String,
    val images : List<String>
)
