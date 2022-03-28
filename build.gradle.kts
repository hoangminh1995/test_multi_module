// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    dependencies {
        classpath ("com.android.tools.build:gradle:${com.example.core.Versions.gradle}")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:${com.example.core.Versions.kotlinVersion}")
    }
}

plugins {
    id ("com.android.application") version "7.1.1" apply false
    id ("com.android.library") version "7.1.1" apply false
    id ("org.jetbrains.kotlin.android") version "1.6.10" apply false
}
