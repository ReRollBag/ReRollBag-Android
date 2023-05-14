import org.gradle.api.JavaVersion

object AppConfig {
    const val compileSdk = 33
    const val targetSdk = 33
    const val minSdk = 21
    const val versionCode = 1
    const val versionName = "1.0.0"
    val sourceCompatibility = JavaVersion.VERSION_17
    val targetCompatibility = JavaVersion.VERSION_17
    const val jvmTarget = "17"
    const val kotlinCompilerExtensionVersion = "1.4.3"
}