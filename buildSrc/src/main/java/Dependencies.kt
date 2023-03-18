

object Versions {
    const val VERSION_KTX = "1.9.0"
    const val VERSION_LIFE = "2.5.1"
    const val VERSION_ROOM = "2.4.3"
    const val VERSION_HILT = "2.44"
    const val VERSION_COROUTINE = "1.6.4"
    const val VERSION_RETROFIT = "2.9.0"
    const val VERSION_OKHTTP = "4.9.2"
    const val VERSION_GLIDE = "4.11.0"
    const val VERSION_LOTTIE = "5.2.0"
    const val VERSION_DATASTORE = "1.0.0"
}
object Dependencies {

    object KTX {
        const val KTX = "androidx.core:core-ktx:${Versions.VERSION_KTX}"
    }

    object Compose {
        const val COMPOSE_BOM = "androidx.compose:compose-bom:2022.10.00"
        const val COMPOSE_MATERIAL3 = "androidx.compose.material3:material3"
        const val COMPOSE_MATERIAL2 = "androidx.compose.material:material"
        const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation"
        const val COMPOSE_UI = "androidx.compose.ui:ui"
        const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview"
        const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling" // debugImplementation
        const val COMPOSE_TEST = "androidx.compose.ui:ui-test-junit4" // androidTestImplementation
        const val COMPOSE_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest" // debugImplementation
        const val COMPOSE_ICON_CORE = "androidx.compose.material:material-icons-core"
        const val COMPOSE_ICON_EXTENDED = "androidx.compose.material:material-icons-extended"
        const val COMPOSE_WINDOW_SIZE = "androidx.compose.material3:material3-window-size-class"
        const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:1.6.1"
        const val COMPOSE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1"
        const val COMPOSE_LIVEDATA = "androidx.compose.runtime:runtime-livedata"
        const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:2.6.0-alpha02"
    }

    object Lifecycle {
        const val LIVEDATA_LIFE = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.VERSION_LIFE}"
        const val VIEWMODEL_LIFE = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.VERSION_LIFE}"
        const val RUNTIME_LIFE = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.VERSION_LIFE}"
    }

    object Room {
        const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.VERSION_ROOM}"
        const val ROOM_KTX = "androidx.room:room-ktx:${Versions.VERSION_ROOM}"
        const val ROOM_COMPILE = "androidx.room:room-compiler:${Versions.VERSION_ROOM}"
    }

    object Hilt {
        const val HILT = "com.google.dagger:hilt-android:${Versions.VERSION_HILT}"
        const val HILT_COMPILE = "com.google.dagger:hilt-compiler:${Versions.VERSION_HILT}"
        const val HILT_COMPOSE_NAVIGATION = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    object Coroutine {
        const val COROUTINE_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.VERSION_COROUTINE}"
        const val COROUTINE_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.VERSION_COROUTINE}"
    }

    object Retrofit {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.VERSION_RETROFIT}"
        const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Versions.VERSION_RETROFIT}"
    }

    object OkHttp {
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.VERSION_OKHTTP}"
        const val OKHTTP_LOGGING = "com.squareup.okhttp3:logging-interceptor:${Versions.VERSION_OKHTTP}"
    }

    object Glide {
        const val GLIDE = "com.github.bumptech.glide:glide:${Versions.VERSION_GLIDE}"
        const val GLIDE_COMPILE = "com.github.bumptech.glide:compiler:${Versions.VERSION_GLIDE}"
    }

    object Lottie {
        const val LOTTIE = "com.airbnb.android:lottie-compose:${Versions.VERSION_LOTTIE}"
    }

    object DataStore {
        const val DATASTORE = "androidx.datastore:datastore:${Versions.VERSION_DATASTORE}"
        const val DATASTORE_PREFERENCE = "androidx.datastore:datastore-preferences:${Versions.VERSION_DATASTORE}"
        const val DATASTORE_PREFERENCE_CORE = "androidx.datastore:datastore-preferences-core:${Versions.VERSION_DATASTORE}"
    }

    object Google {
        const val MAP = "com.google.android.gms:play-services-maps:18.1.0"
        const val MAP_COMPOSE = "com.google.maps.android:maps-compose:2.7.2"
        const val FIREBASE = "com.google.firebase:firebase-bom:31.2.2"
        const val FIREBASE_ANALYTICS = "com.google.firebase:firebase-analytics-ktx"
        const val FIREBASE_AUTH = "com.google.firebase:firebase-auth-ktx"
        const val AUTH = "com.google.android.gms:play-services-auth:20.4.1"
    }

    object Kakao {
        const val ALL = "com.kakao.sdk:v2-all:2.13.0"
        const val LOGIN = "com.kakao.sdk:v2-user:2.13.0"
        const val TALK = "com.kakao.sdk:v2-talk:2.13.0"
        const val SHARE = "com.kakao.sdk:v2-share:2.13.0"
        const val NAVI = "com.kakao.sdk:v2-navi:2.13.0"
    }

    object Zxing {
        const val QR = "com.journeyapps:zxing-android-embedded:4.3.0"
    }

    object ThreeTenabp {
        const val THREETENABP = "com.jakewharton.threetenabp:threetenabp:1.3.0"
    }

}