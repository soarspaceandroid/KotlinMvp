package com.soarlibrary.request

interface RequestLisenter<T:BaseBean> {

    fun onSuccess(baseBean: T)
    fun onFail(baseBean: T)
    fun onNetError(e:Exception)
    fun onDataError(e:Exception)
}