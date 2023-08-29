import buildtype.AndroidBuildType.debug
import buildtype.AndroidBuildType.release
import config.AndroidConfig
import dependencies.Dependencies

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
}

@Suppress("UnstableApiUsage")
android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        namespace = AndroidConfig.appNameSpace
        minSdk = AndroidConfig.minSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
        testInstrumentationRunner = AndroidConfig.testInstrumentRunner
    }

    buildTypes {
        named(debug) {
            isMinifyEnabled = false
            buildConfigField("String", "baseUrl",  "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String", "imageUrl", "\"https://image.tmdb.org/t/p/w500/\"")
            buildConfigField("String", "apiKey", "\"fbb9572d11b5458ac98f02b84f2bafc4\"")
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        named(release) {
            isMinifyEnabled = true
            buildConfigField("String", "baseUrl",  "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String", "imageUrl", "\"https://image.tmdb.org/t/p/w500/\"")
            buildConfigField("String", "apiKey", "\"fbb9572d11b5458ac98f02b84f2bafc4\"")
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
}

dependencies {
    Dependencies.AndroidLib.apply {
        implementation(core)
        implementation(appCompat)
        implementation(navigationIu)
        implementation(navigationFragment)
        implementation(constraintLayout)
    }

    Dependencies.UiLib.apply {
        implementation(material)
        implementation(glide)
        implementation(shimmer)
    }

    Dependencies.NetworkingLib.apply {
        implementation(retrofit2)
        implementation(rxJava)
        implementation(converterGson)
        implementation(okhttp)
        implementation(okhttpInterceptor)
        debugImplementation(chucker)
        releaseImplementation(chuckerNoop)
    }

    Dependencies.DependencyInjectionLib.apply {
        implementation(hilt)
        kapt(hiltCompiler)
        kapt(hiltAndroidCompiler)
    }

    Dependencies.ReactiveLib.apply {
        implementation(rxAndroid)
        implementation(rxJava)
        implementation(rxBinding)
    }

    Dependencies.TestingLib.apply {
        testImplementation(androidJunit)
        androidTestImplementation(espresso)
        androidTestImplementation(junit)
    }
}
