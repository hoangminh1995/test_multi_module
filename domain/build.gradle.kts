import com.example.core.Libraries
import com.example.core.KotlinLibraries
import com.example.core.AndroidLibraries
import com.example.core.Modules

plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
}

android {
    compileSdk = com.example.core.Versions.compileSdkVersion

    defaultConfig {
        minSdk = com.example.core.Versions.minSdk
        targetSdk= com.example.core.Versions.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        isCoreLibraryDesugaringEnabled = true
    }

    kotlinOptions {
        jvmTarget = com.example.core.Versions.jvmTarget
        freeCompilerArgs = freeCompilerArgs.toMutableList().apply { add("-Xopt-in=kotlin.RequiresOptIn") }.toList()
    }
}
dependencies {
    implementation(project(Modules.common))

    implementation (Libraries.gson)
    implementation (Libraries.daggerHilt)
    kapt (Libraries.daggerHiltKapt)

    implementation(KotlinLibraries.androidKotlinCoroutine)

    implementation (AndroidLibraries.room)
    implementation (AndroidLibraries.roomCompiler)
}
