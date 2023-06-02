plugins {
    id("com.android.application") version "8.0.1" apply false
    id("com.android.library") version "8.0.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false
}
buildscript {
    extra.apply{
        set("compose_version", AppConfig.kotlinCompilerExtensionVersion)
    }
    dependencies {
        classpath("com.google.gms:google-services:4.3.15")
    }
    repositories {
        maven(url = "https://devrepo.kakao.com/nexus/content/groups/public/")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}