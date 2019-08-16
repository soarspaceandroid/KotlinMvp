package com.soarlibrary.request

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class OkClientFactory{
    companion object {
        val builder by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            OkHttpClient.Builder()
        }
        fun create(): OkHttpClient {
            return builder!!.build()
        }
    }


    constructor(){
        builder?.connectTimeout(10 , TimeUnit.SECONDS)
        builder?.readTimeout(10 , TimeUnit.SECONDS)
    }
}