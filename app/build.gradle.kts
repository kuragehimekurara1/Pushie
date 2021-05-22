plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
        applicationId = "com.chesire.pushie"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        resConfigs("en")
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":feature:pusher"))
    implementation(project(":library:common"))
    implementation(project(":library:datasource:pwpush"))
    implementation(project(":library:resources"))

    implementation("androidx.activity:activity-ktx:1.2.3")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.core:core-ktx:1.5.0")
    implementation("com.chesire.lintrules:lint-gradle:1.2.6")
    implementation("com.chesire.lintrules:lint-xml:1.2.6")
    implementation("com.google.android.material:material:1.3.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
}
