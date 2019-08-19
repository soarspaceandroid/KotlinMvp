package com.soarlibrary.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment<T:BaseView<*>>:Fragment() {

    private var baseView:T? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        baseView = createView()
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    fun  getBaseView():T{
        return baseView!!
    }


    abstract fun createView():T
}