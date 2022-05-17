package com.example.core

object ApplicationId {
    val id = "com.example.mikecleanarchitecture"
}

object Modules {
    val common = ":common"
    val data = ":data"
    val domain = ":domain"
}

/**
 * Arranged alphabetically
 */
object Versions {
    val minSdk = 21
    val targetSdk = 32
    val compileSdkVersion = 32
    val jvmTarget = "1.8"

    val appCompat = "1.3.1"
    val material = "1.4.0"
    val coreKtx = "1.6.0"
    val dagger_hilt = "2.38.1"
    val loggingInterceptor = "4.9.0"
    val gson = "2.8.5"

    val androidTestRunner = "1.2.0"
    val androidJunit = "1.1.0"
    val constraintLayout = "2.1.0"
    val coroutines = "1.3.5"
    val dagger = "2.24"
    val espressoCore = "3.2.0"
    val fragment = "1.3.2"
    val gradle = "4.0.1"
    val kotlinVersion = "1.4.10"
    val kotlinCoroutine = "1.3.5-native-mt"
    val retrofit = "2.9.0"
    val lifecycleVersion = "2.4.0-alpha03"
}

object Libraries {
    // Dagger hilt core
    val daggerHilt = "com.google.dagger:hilt-android:${Versions.dagger_hilt}"
    val daggerHiltKapt = "com.google.dagger:hilt-compiler:${Versions.dagger_hilt}"

    // Retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
}

object KotlinLibraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    val coreKotlinCoroutine =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutine}"
    val androidKotlinCoroutine =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutine}"
}

object AndroidLibraries {
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleVersion}"
    val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val material = "com.google.android.material:material:${Versions.material}"
    val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
}
