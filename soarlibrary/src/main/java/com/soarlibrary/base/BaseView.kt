package com.soarlibrary.base

import android.content.Context

open class BaseView<T>(private var contextB: Context) : BaseViewInter<T> {

    override fun onBindUI() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showWaitting() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailUI() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun disWaitting() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun getContext(): T {
        when (contextB){
            is BaseActivity<*> -> return contextB as T
            is BaseFragment<*> -> return ((contextB as BaseFragment<*>).activity) as T
            else -> return contextB as T
        }
    }

}