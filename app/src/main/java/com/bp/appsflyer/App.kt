package com.bp.appsflyer

import android.app.Application
import android.util.Log
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.appsflyer.deeplink.DeepLinkListener
import com.appsflyer.deeplink.DeepLinkResult

/**
 * Created on 01.08.2022.
 */
class App : Application() {

    val TAG = "AppsFlyerTag"

    private object AppsFlyer {
        const val DEV_KEY = "JdMGBJgZAVFDEKDfbXHLGS"
    }

    override fun onCreate() {
        super.onCreate()
        AppsFlyerLib.getInstance().init(AppsFlyer.DEV_KEY, object : AppsFlyerConversionListener {
            override fun onConversionDataSuccess(p0: MutableMap<String, Any>?) {
                Log.d(TAG, "onConversionDataSuccess: $p0")
            }

            override fun onConversionDataFail(p0: String?) {
                Log.d(TAG, "onConversionDataFail: $p0")
            }

            override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {
                Log.d(TAG, "onAppOpenAttribution: $p0")
            }

            override fun onAttributionFailure(p0: String?) {
                Log.d(TAG, "onAttributionFailure: $p0")
            }
        }, this)

        AppsFlyerLib.getInstance().start(this)

        AppsFlyerLib.getInstance().subscribeForDeepLink { TODO("Not yet implemented") }


    }

}