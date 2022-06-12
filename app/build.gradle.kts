import com.example.core.AndroidLibraries
import com.example.core.Libraries
import com.example.core.Modules
import com.example.core.Versions

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Versions.compileSdkVersion

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = Versions.jvmTarget
        freeCompilerArgs =
            freeCompilerArgs.toMutableList().apply { add("-Xopt-in=kotlin.RequiresOptIn") }.toList()
    }
}

hilt {
    enableExperimentalClasspathAggregation = true
}

dependencies {
    implementation(project(Modules.common))
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    implementation(Libraries.daggerHilt)
    kapt(Libraries.daggerHiltKapt)
    implementation(AndroidLibraries.coreKtx)
    implementation(AndroidLibraries.lifecycleRuntime)
    implementation(AndroidLibraries.lifecycleCommon)
    implementation(AndroidLibraries.lifecycleLiveData)
    implementation(AndroidLibraries.lifecycleViewModel)
    implementation(AndroidLibraries.appCompat)
    implementation(AndroidLibraries.constraint)
    implementation(AndroidLibraries.material)
    implementation(AndroidLibraries.fragment)
}
