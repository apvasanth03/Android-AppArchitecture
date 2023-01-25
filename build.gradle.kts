buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(libs.androidPlugin)
        classpath(libs.kotlinAndroidPlugin)
        classpath(libs.daggerHiltAndroidPlugin)
    }
}