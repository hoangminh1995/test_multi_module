import com.example.core.AndroidLibraries

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = com.example.core.Versions.compileSdkVersion

    defaultConfig {
        minSdk = com.example.core.Versions.minSdk
        targetSdk = com.example.core.Versions.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = com.example.core.Versions.jvmTarget
        freeCompilerArgs =
            freeCompilerArgs.toMutableList().apply { add("-Xopt-in=kotlin.RequiresOptIn") }.toList()
    }
}

dependencies {
    implementation(AndroidLibraries.coreKtx)
    implementation(AndroidLibraries.appCompat)
    implementation(AndroidLibraries.constraint)
    implementation(AndroidLibraries.material)
    implementation(AndroidLibraries.fragment)
}
