import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("com.google.gms.google-services")
}

fun getApiKey(propertyKey: String): String = gradleLocalProperties(rootDir).getProperty(propertyKey)

android {
    namespace = "com.mediaproject.rerollbag"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.mediaproject.rerollbag"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.userVersionCode
        versionName = AppConfig.userVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        manifestPlaceholders["MAPS_API_KEY"] = getApiKey("MAPS_API_KEY")
        manifestPlaceholders["GOOGLE_CLIENT_KEY"] = getApiKey("GOOGLE_CLIENT_KEY")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
        debug {
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
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
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.kotlinCompilerExtensionVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":presentation:user"))
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(Dependencies.KTX.KTX)
    implementation(Dependencies.Hilt.HILT)
    kapt(Dependencies.Hilt.HILT_COMPILE)
    implementation(Dependencies.Retrofit.RETROFIT)
    implementation(Dependencies.Retrofit.RETROFIT_GSON)
    implementation(Dependencies.OkHttp.OKHTTP)
    implementation(Dependencies.OkHttp.OKHTTP_LOGGING)
    implementation(Dependencies.Room.ROOM_KTX)
    implementation(Dependencies.Room.ROOM_RUNTIME)
    kapt(Dependencies.Room.ROOM_COMPILE)
    implementation(Dependencies.DataStore.DATASTORE_PREFERENCE)
    implementation(Dependencies.DataStore.DATASTORE_PREFERENCE_CORE)

    implementation(Dependencies.Google.MAP)
    implementation(Dependencies.Google.MAP_COMPOSE)
    implementation(platform(Dependencies.Google.FIREBASE))
    implementation(Dependencies.Google.FIREBASE_ANALYTICS)
    implementation(Dependencies.Google.FIREBASE_AUTH)
    implementation(Dependencies.Google.AUTH)

    implementation(Dependencies.Kakao.ALL)

    implementation(Dependencies.ThreeTenabp.THREETENABP)
}