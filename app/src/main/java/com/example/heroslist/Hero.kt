package com.example.heroslist

import android.graphics.drawable.Drawable

data class Hero(
    var name: String,
    var description: String,
    var superpower: String,
    var ranking: Int,
    var Image: Drawable,
){
}
