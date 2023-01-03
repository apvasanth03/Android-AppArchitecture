// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application").version(Versions.activityGradlePlugin).apply(false)
    id("com.android.library").version(Versions.activityGradlePlugin).apply(false)
    id("org.jetbrains.kotlin.android").version(Versions.kotlin).apply(false)
    id("com.google.dagger.hilt.android").version(Versions.daggerHilt).apply(false)
}