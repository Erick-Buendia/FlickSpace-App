plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.erick.buendia.appmovie"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.erick.buendia.appmovie"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    val navigationVersion = "2.7.7"
    val roomVersion = "2.6.1"
    val daggerHiltVersion = "2.52"

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    //ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.3")
    //Retofit para las peticiones a la API
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    //Glide permite obtener, decodificar y mostrar imágenes fijas de video, imágenes y GIF animados.
    implementation("com.github.bumptech.glide:glide:4.16.0")
    // Para usar fragamentos en android
    implementation("androidx.fragment:fragment-ktx:1.8.1")
    //Navigation Component
    implementation("androidx.navigation:navigation-fragment-ktx:${navigationVersion}")
    implementation("androidx.navigation:navigation-ui-ktx:${navigationVersion}")
    //Room
    implementation("androidx.room:room-ktx:${roomVersion}")
    kapt("androidx.room:room-compiler:$roomVersion")

    // Dagger Hilt Inyeccion de dependencias
    implementation("com.google.dagger:hilt-android:${daggerHiltVersion}")
    kapt("com.google.dagger:hilt-android-compiler:${daggerHiltVersion}")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


}
kapt {
    correctErrorTypes = true
}