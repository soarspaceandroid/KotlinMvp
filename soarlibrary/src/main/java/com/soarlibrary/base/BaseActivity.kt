package com.soarlibrary.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<T:BaseView<*>> : AppCompatActivity(){


    private var baseView:T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //view初始化
        baseView = createView()
    }


    fun  getBaseView():T{
        return baseView!!
    }


    abstract fun createView():T


    /**
     * 可以复写
     */
    open fun getData(){
        baseView?.showWaitting()
//        RequestHelper.getInstance().post()
    }


}