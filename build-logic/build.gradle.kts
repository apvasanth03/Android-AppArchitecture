plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(libs.androidPlugin)
    implementation(libs.kotlinAndroidPlugin)
}