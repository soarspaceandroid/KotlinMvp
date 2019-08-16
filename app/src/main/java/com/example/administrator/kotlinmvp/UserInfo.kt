package com.example.administrator.kotlinmvp

import com.soarlibrary.request.BaseBean

class UserInfo:BaseBean(){
    var data:Data? = null
    inner class Data{
        var userId:String = ""
        var phone:String = ""
    }

}