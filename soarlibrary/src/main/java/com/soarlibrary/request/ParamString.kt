package com.soarlibrary.request

class ParamString{

    var params:HashMap<String ,String>? = null

    constructor(){
        params = HashMap<String , String>()
    }

    fun put(key: String, value: String): ParamString {
        params?.put(key , value)
        return this
    }

    fun build(): HashMap<String , String>{
        return params!!
    }



}