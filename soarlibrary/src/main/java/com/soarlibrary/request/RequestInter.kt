package com.soarlibrary.request

interface RequestInter {

    fun get(url:String, lisenter: RequestLisenter<BaseBean>, clz:Class<*>)

    fun post(url:String , params:HashMap<String , String>, lisenter: RequestLisenter<BaseBean>, clz:Class<*>)

    fun downloadFile(url:String)

    fun uploadFile(url:String)

}