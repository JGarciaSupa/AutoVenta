plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
//    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.lobitoconsulting.autoventa"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.lobitoconsulting.autoventa"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.generativeai)


    // Core Android dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    //Koin Android
    implementation(libs.androidx.koin)
//    implementation(libs.androidx.koin.android)
    implementation(libs.androidx.koin.navigation)
//    implementation(libs.androidx.koin.test)

    //GSON
    implementation(libs.gson)

    //Retrofit
    implementation(libs.androidx.retrofit)
    implementation(libs.androidx.retrofit.moshi)
    implementation(libs.androidx.retrofit.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    // KConMapper (KCM)
    implementation(libs.kconmapper.annotations)
    ksp(libs.kconmapper.compiler)


    // Serialization Kotlin Json
    implementation(libs.kotlinx.serialization.json)

    // Arch Components
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // KConMapper (KCM)
    implementation(libs.kconmapper.annotations)
    ksp(libs.kconmapper.compiler)

    //ROOM
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    // NAVEGACION COMPOSE
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}