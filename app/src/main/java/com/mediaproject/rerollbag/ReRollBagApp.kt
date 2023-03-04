package com.mediaproject.rerollbag

import android.app.Application
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ReRollBagApp : Application() {
    companion object {

        private lateinit var application: ReRollBagApp

        fun getInstance() : ReRollBagApp = application

    }

    override fun onCreate(){
        super.onCreate()
        application = this
        val applicationInfo = packageManager.getApplicationInfoCompat(packageName, PackageManager.GET_META_DATA)
        val metaData = applicationInfo.metaData
        val kakaoKey = metaData.getString("com.kakao.sdk.AppKey")
        KakaoSdk.init(
            context = this,
            appKey = kakaoKey ?: "",
            loggingEnabled = true,
        )
    }

    private fun PackageManager.getApplicationInfoCompat(packageName: String, flags: Int = 0): ApplicationInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(flags.toLong()))
    } else {
        @Suppress("DEPRECATION") getApplicationInfo(packageName, flags)
    }
}