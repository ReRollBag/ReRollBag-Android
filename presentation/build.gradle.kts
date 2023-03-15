import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("com.google.gms.google-services")
}

fun getApiKey(propertyKey: String): String = gradleLocalProperties(
    rootDir
).getProperty(propertyKey)

android {
    namespace = "com.mediaproject.presentation"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        vectorDrawables {
            useSupportLibrary = true
        }

        manifestPlaceholders["KAKAO_KEY"] = getApiKey("KAKAO_KEY")
        manifestPlaceholders["KAKAO_REDIRECTION_KEY"] = getApiKey("KAKAO_REDIRECTION_KEY")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.kotlinCompilerExtensionVersion
    }
}

dependencies {
    implementation(project(":domain"))

    val composeBom = platform(Dependencies.Compose.COMPOSE_BOM)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(Dependencies.KTX.KTX)
    implementation(Dependencies.Compose.COMPOSE_MATERIAL2)
    implementation(Dependencies.Compose.COMPOSE_FOUNDATION)
    implementation(Dependencies.Compose.COMPOSE_UI)
    implementation(Dependencies.Compose.COMPOSE_PREVIEW)
    implementation(Dependencies.Compose.COMPOSE_ACTIVITY)
    implementation(Dependencies.Compose.COMPOSE_VIEWMODEL)
    implementation(Dependencies.Compose.COMPOSE_LIVEDATA)
    implementation(Dependencies.Compose.COMPOSE_NAVIGATION)
    implementation(Dependencies.Lifecycle.LIVEDATA_LIFE)
    implementation(Dependencies.Lifecycle.VIEWMODEL_LIFE)
    implementation(Dependencies.Lifecycle.RUNTIME_LIFE)

    implementation(Dependencies.Hilt.HILT)
    implementation(Dependencies.Hilt.HILT_COMPOSE_NAVIGATION)
    kapt(Dependencies.Hilt.HILT_COMPILE)

    implementation(Dependencies.Lottie.LOTTIE)

    implementation(Dependencies.Google.MAP)
    implementation(Dependencies.Google.MAP_COMPOSE)
    implementation(platform(Dependencies.Google.FIREBASE))
    implementation(Dependencies.Google.FIREBASE_ANALYTICS)
    implementation(Dependencies.Google.FIREBASE_AUTH)
    implementation(Dependencies.Google.AUTH)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(Dependencies.Compose.COMPOSE_TEST)
    debugImplementation(Dependencies.Compose.COMPOSE_TOOLING)
    debugImplementation(Dependencies.Compose.COMPOSE_TEST_MANIFEST)

    implementation(Dependencies.Kakao.ALL)

    implementation(Dependencies.Zxing.QR)
}