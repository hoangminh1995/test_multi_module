plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
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
    implementation(project(com.example.core.Modules.core))
    implementation(project(com.example.core.Modules.common))
    implementation(project(com.example.core.Modules.data))
    implementation(project(com.example.core.Modules.domain))

    implementation (com.example.core.Libraries.daggerHilt)
    kapt(com.example.core.Libraries.daggerHiltKapt)
    implementation(com.example.core.AndroidLibraries.coreKtx)
    implementation(com.example.core.AndroidLibraries.appCompat)
    implementation(com.example.core.AndroidLibraries.constraint)
    implementation(com.example.core.AndroidLibraries.material)
    implementation(com.example.core.AndroidLibraries.fragment)
}
