// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    // Add the SafeArgs functionality to the project
    id("androidx.navigation.safeargs.kotlin") version "2.7.1" apply false
    // Add KSP for Kotlin
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
}