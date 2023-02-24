package com.example.tackapp_1.Utils

import android.content.Context
import android.content.SharedPreferences

class Preferencas(context: Context) {

    val  sharedPreferenc:SharedPreferences = context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

    var board: Boolean
        get() = sharedPreferenc.getBoolean("board", false)
    set(value) = sharedPreferenc.edit().putBoolean("board", value). apply()

    fun setBoardingShowed(isShow : Boolean){
        sharedPreferenc.edit().putBoolean("board", isShow).apply()
    }

    fun getBoardingShowed(): Boolean{
        return sharedPreferenc.getBoolean("board", false)

    }
}