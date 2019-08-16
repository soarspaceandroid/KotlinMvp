package com.soarlibrary.request

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class OkClientFactory{
    companion object {
        val builder by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            OkHttpClient.Builder()
        }
        fun create(): OkHttpClient {
            OkClientFactory()
            return builder!!.build()
        }
    }


    constructor(){
        builder?.connectTimeout(10 , TimeUnit.SECONDS)
        builder?.readTimeout(10 , TimeUnit.SECONDS)
        builder?.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    }
}