plugins {
    id("fs-android-library")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.vasanth.commoncore"

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
}

dependencies {

    // Kotlin
    implementation(libs.kotlin)
    implementation(libs.coroutines)

    // Android
    implementation(libs.coreKtx)
    implementation(libs.appCompat)
    implementation(libs.viewModelKtx)
    implementation(platform(libs.composeBom))
    implementation(libs.bundles.compose)

    // Google
    implementation(libs.daggerHiltAndroid)
    kapt(libs.daggerHiltAndroidCompiler)
}