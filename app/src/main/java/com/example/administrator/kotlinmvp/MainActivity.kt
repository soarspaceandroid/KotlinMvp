package com.example.administrator.kotlinmvp

import android.os.Bundle
import android.util.Log
import com.soarlibrary.base.BaseActivity
import com.soarlibrary.request.BaseBean
import com.soarlibrary.request.ParamString
import com.soarlibrary.request.RequestHelper
import com.soarlibrary.request.RequestLisenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : BaseActivity<MainView>() ,RequestLisenter<UserInfo> {

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



        getBaseView().print()



    }


    override fun getData() {
        super.getData()
        RequestHelper.getInstance().post("http://116.228.243.146/Account/userInfo" , ParamString().put("userId","6540059105892162561").build() , this as RequestLisenter<BaseBean> , UserInfo().javaClass)
    }

    override fun createView(): MainView {
        return MainView(this)
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

    fun callBack(){
        Log.e("soar" , "mainactivity --- callback")
    }

}
