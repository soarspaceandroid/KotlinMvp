package com.soarlibrary.request

import com.google.gson.Gson

class GsonFactory {
    companion object{
        val gson by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Gson()
        }
        fun create():Gson{
            return gson!!
        }
    }
}