package com.tony_fire.tesla
import android.app.Application
import android.util.Log
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import kotlin.collections.Map

class AFApplication : Application() {
    private val devKey = "48gB6vJPnXQnJN4QrdNcjK";


    override fun onCreate() {
        super.onCreate()
        val conversionDataListener  = object : AppsFlyerConversionListener{
            override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
                data?.let { cvData ->
                    cvData.map {
                        Log.i("MyLog", "conversion_attribute:  ${it.key} = ${it.value}")
                    }
                }
            }

            override fun onConversionDataFail(error: String?) {
                Log.e("MyLog", "error onAttributionFailure :  $error")
            }

            override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
                data?.map {
                    Log.d("MyLog", "onAppOpen_attribute: ${it.key} = ${it.value}")
                }
            }

            override fun onAttributionFailure(error: String?) {
                Log.e("MyLog", "error onAttributionFailure :  $error")
            }
        }

        AppsFlyerLib.getInstance().init(devKey, conversionDataListener, this)
        AppsFlyerLib.getInstance().start(this)

    }
}