package com.example.cuadriculalistas.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic (

    @StringRes val stringResourceId: Int,
    val dato : Int,
    @DrawableRes val imageResourceId1: Int
)