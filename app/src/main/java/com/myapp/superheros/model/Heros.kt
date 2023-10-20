package com.myapp.superheros.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Heros(
   @StringRes val name:Int,
    @StringRes val description:Int,
    @DrawableRes val image:Int
)
