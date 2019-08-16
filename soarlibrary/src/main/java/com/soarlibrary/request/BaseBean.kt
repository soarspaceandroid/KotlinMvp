package com.soarlibrary.request

open class BaseBean<T> {
    var code:Int = 0
    var msg:String = ""
    var data:T? = null
}