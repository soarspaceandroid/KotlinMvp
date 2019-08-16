package com.soarlibrary.request

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response

class RequestHelper private constructor(): RequestInter{

    val requestBuilder: Request.Builder = Request.Builder()

    companion object {
        val helper by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            RequestHelper()
        }

        fun getInstance():RequestInter {
            return helper!!
        }
    }





    override fun get(url: String, lisenter: RequestLisenter<BaseBean>, clz: Class<*>) {
        CoroutineScope(Dispatchers.IO).launch {
            var response: Response? = null
            try {
                response = OkClientFactory.create().newCall(requestBuilder.url(url).get().build()).execute()
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    lisenter?.onNetError(e)
                }
            }
            //本地请求
            try {
                var basebean = GsonFactory.create().fromJson(response?.body.toString(), clz) as BaseBean
                if (basebean.code == 10000) {
                    CoroutineScope(Dispatchers.Main).launch {
                        lisenter?.onSuccess(basebean)
                    }
                } else {
                    CoroutineScope(Dispatchers.Main).launch {
                        lisenter?.onFail(basebean)
                    }
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    lisenter?.onDataError(e)
                }
            }
        }
    }

    override fun post(url: String, params:HashMap<String , String>, lisenter: RequestLisenter<BaseBean>, clz: Class<*>) {

        CoroutineScope(Dispatchers.IO).launch {
            var jsonParams = GsonFactory.create().toJson(params)
            val body = jsonParams.toRequestBody("application/json; charset=utf-8".toMediaType())
            var response: Response? = null
            var request = requestBuilder.url(url).addHeader("PLATFORM","android").addHeader("DEVICENO","868030024884122").addHeader("AUTHORIZATION" , "0da9d9297f3d053b8576f99edf059141d76da4ec").addHeader("VERSION","v3.0.0").post(body).build()
            try {
                response = OkClientFactory.create().newCall(request).execute()
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    e.printStackTrace()
                    lisenter?.onNetError(e)
                }
            }
            //本地请求
            try {
                val jsonRespose = response?.body?.string()
                var basebean = GsonFactory.create().fromJson(jsonRespose, clz) as BaseBean
                if (basebean.code == 1000) {
                    CoroutineScope(Dispatchers.Main).launch {
                        lisenter?.onSuccess(basebean)
                    }
                } else {
                    CoroutineScope(Dispatchers.Main).launch {
                        lisenter?.onFail(basebean)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                CoroutineScope(Dispatchers.Main).launch {
                    lisenter?.onDataError(e)
                }
            }
        }

    }


    override fun downloadFile(url: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun uploadFile(url: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


