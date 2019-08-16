package com.example.administrator.kotlinmvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.soarlibrary.request.BaseBean
import com.soarlibrary.request.ParamString
import com.soarlibrary.request.RequestHelper
import com.soarlibrary.request.RequestLisenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() ,RequestLisenter<UserInfo> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        CoroutineScope(Dispatchers.Main).launch {
            Log.e("soar" , "1112     "+ Thread.currentThread())
        }


        GlobalScope.launch(){
            sample_text?.setText("test")
            Log.e("soar" , "122222  "+ Thread.currentThread())
        }


        MainScope().launch{
            Log.e("soar" , "------"+Thread.currentThread())
        }



        RequestHelper.getInstance().post("http://116.228.243.146/Account/userInfo" , ParamString().put("userId","6540059105892162561").build() , this as RequestLisenter<BaseBean> , UserInfo().javaClass)
        RequestHelper.getInstance().post("http://116.228.243.146/Account/userInfo" , ParamString().put("userId","6540059105892162561").build() , this as RequestLisenter<BaseBean> , UserInfo().javaClass)
        RequestHelper.getInstance().post("http://116.228.243.146/Account/userInfo" , ParamString().put("userId","6540059105892162561").build() , this as RequestLisenter<BaseBean> , UserInfo().javaClass)
        RequestHelper.getInstance().post("http://116.228.243.146/Account/userInfo" , ParamString().put("userId","6540059105892162561").build() , this as RequestLisenter<BaseBean> , UserInfo().javaClass)
        RequestHelper.getInstance().post("http://116.228.243.146/Account/userInfo" , ParamString().put("userId","6540059105892162561").build() , this as RequestLisenter<BaseBean> , UserInfo().javaClass)
        RequestHelper.getInstance().post("http://116.228.243.146/Account/userInfo" , ParamString().put("userId","6540059105892162561").build() , this as RequestLisenter<BaseBean> , UserInfo().javaClass)
        RequestHelper.getInstance().post("http://116.228.243.146/Account/userInfo" , ParamString().put("userId","6540059105892162561").build() , this as RequestLisenter<BaseBean> , UserInfo().javaClass)






    }


    override fun onSuccess(baseBean: UserInfo) {
        Log.e("soar" , "success --- "+baseBean?.data?.phone)
        sample_text.setText(baseBean?.data?.phone)
    }

    override fun onFail(baseBean: UserInfo) {
    }

    override fun onDataError(e:Exception) {
        Log.e("soar" , "e----> "+e.message)
    }

    override fun onNetError(e:Exception) {
        Log.e("soar" , "e----> "+e.message)
    }

}
