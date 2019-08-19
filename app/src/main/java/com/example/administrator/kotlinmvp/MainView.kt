package com.example.administrator.kotlinmvp

import android.content.Context
import android.util.Log
import com.soarlibrary.base.BaseView

class MainView(var context:Context):BaseView<MainActivity>(context) {

    fun print(){
        Log.e("soar" , "print ---> mainview")
        getContext().callBack()
    }


}