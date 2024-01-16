plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.mediaproject.data"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppConfig.sourceCompatibility
        targetCompatibility = AppConfig.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }
}

dependencies {
    implementation(project(":core:model"))

    implementation(Dependencies.KTX.KTX)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation(Dependencies.Hilt.HILT)
    kapt(Dependencies.Hilt.HILT_COMPILE)
    implementation(Dependencies.Retrofit.RETROFIT)
    implementation(Dependencies.Retrofit.RETROFIT_GSON)
    implementation(Dependencies.OkHttp.OKHTTP)
    implementation(Dependencies.OkHttp.OKHTTP_LOGGING)
    implementation(Dependencies.Coroutine.COROUTINE_CORE)
    implementation(Dependencies.Coroutine.COROUTINE_ANDROID)
    implementation(Dependencies.Room.ROOM_KTX)
    implementation(Dependencies.Room.ROOM_RUNTIME)
    kapt(Dependencies.Room.ROOM_COMPILE)
    implementation(Dependencies.DataStore.DATASTORE_PREFERENCE)
    implementation(Dependencies.DataStore.DATASTORE_PREFERENCE_CORE)
}