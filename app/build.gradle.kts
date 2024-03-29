plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.chaquo.python")
}

android {
    namespace = "com.example.trest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.trest"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true

            ndk {
                // On Apple silicon, you can omit x86_64.
                abiFilters += listOf("arm64-v8a", "x86_64")
            }

        }
    }
    flavorDimensions += "pyVersion"
    productFlavors {
        create("py311") { dimension = "pyVersion" }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
chaquopy {
    productFlavors {
        getByName("py311") { version = "3.11" }
    }

    defaultConfig {
        buildPython("C:/Users/hrith/AppData/Local/Programs/Python/Python311/python.exe")

        pip {
            // A requirement specifier, with or without a version number:
            install("pandas")
            //install("pickle")
            //install("scikit-learn")
        }
    }
    sourceSets.getByName("main") {
        setSrcDirs(listOf("src/main/python"))
    }
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("commons-io:commons-io:2.11.0")

}