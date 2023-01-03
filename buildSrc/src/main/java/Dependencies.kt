object Dependencies {

    // Module
    val commonCore = ":libraries:common-core"

    // Kotlin
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.coroutines}"
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"

    // Android
    var coreKtx = "androidx.core:core-ktx:${Versions.core}"
    var appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    var activityKtx = "androidx.activity:activity:${Versions.activity}"
    var activityCompose = "androidx.activity:activity-compose:${Versions.activity}"
    val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
    val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    val composeMaterial = "androidx.compose.material:material"
    val composeUITooling = "androidx.compose.ui:ui-tooling"
    val composeUIToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUIKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // Google
    val daggerHiltAndroid = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    val daggerHiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"

    // Others
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    // Test
    val junit = "junit:junit:${Versions.junit}"
    val androidXJunitExtKtx = "androidx.test.ext:junit-ktx:${Versions.androidXJunitExt}"
    val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Versions.mockitoKotlin}"
    val hamcrest = "org.hamcrest:hamcrest:${Versions.hamcrest}"
    val kotlinFixture = "com.appmattus.fixture:fixture:${Versions.kotlinFixture}"
    val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    val archCoreTesting = "androidx.arch.core:core-testing:${Versions.archCore}"
}