import com.example.core.Libraries

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

        buildConfigField ("String", "ENDPOINT_URL", "\"https://api.openweathermap.org/data/2.5/\"")

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
    implementation (Libraries.daggerHilt)
    kapt(Libraries.daggerHiltKapt)
    implementation (Libraries.gson)
    implementation (Libraries.loggingInterceptor)
    implementation (Libraries.retrofit)
    implementation (Libraries.retrofitConverter)
}
