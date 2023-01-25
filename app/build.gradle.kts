plugins {
    id("fs-android-application")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.vasanth.apparchitecture"

    defaultConfig {
        applicationId = "com.vasanth.apparchitecture"
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {

    // Module
    implementation(project(":libraries:common-core"))

    // Kotlin
    implementation(libs.kotlin)
    implementation(libs.coroutines)

    // Android
    implementation(libs.viewModelKtx)
    implementation(platform(libs.composeBom))
    implementation(libs.bundles.compose)
    implementation(libs.bundles.navigation)

    // Google
    implementation(libs.daggerHiltAndroid)
    kapt(libs.daggerHiltAndroidCompiler)

    // Others
    implementation(libs.bundles.retrofit)

    // Test
    testImplementation(libs.junit)
    testImplementation(libs.robolectric)
    testImplementation(libs.androidXJunitExtKtx)
    testImplementation(libs.mockitoKotlin)
    testImplementation(libs.hamcrest)
    testImplementation(libs.kotlinFixture)
    testImplementation(libs.archCoreTesting)
    testImplementation(libs.coroutinesTest)
    testImplementation(libs.hamcrest)
}