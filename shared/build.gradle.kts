import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization")
    kotlin("kapt")
    id("com.android.library")
    id("kotlin-parcelize")
    id("com.squareup.sqldelight")
}

version = "1.0"

kotlin {
    android()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget = when {
        System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
        else -> ::iosX64
    }

    iosTarget("ios") {}

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        frameworkName = "shared"
        podfile = project.file("../iosApp/Podfile")
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0-native-mt"){
                    version {
                        strictly("1.5.0-native-mt")
                    }
                }
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.2.2")
                implementation("io.ktor:ktor-client-core:1.6.2")
                implementation("io.ktor:ktor-client-serialization:1.6.2")
                implementation("com.squareup.sqldelight:runtime:1.5.1")
                implementation("com.squareup.sqldelight:coroutines-extensions:1.5.1")
                implementation("io.ktor:ktor-client-logging:1.6.2")
                implementation("io.insert-koin:koin-core:3.1.2")
                implementation("dev.icerock.moko:parcelize:0.7.1")
                implementation(kotlin("stdlib-common"))
                implementation("com.russhwolf:multiplatform-settings:0.8")
                implementation("com.futuremind:koru:0.7.0")
                configurations.get("kapt").dependencies.add(
                    org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency(
                        "com.futuremind", "koru-processor", "0.7.0"
                    )
                )
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:1.6.2")
                implementation("com.squareup.sqldelight:android-driver:1.5.1")
                implementation("io.ktor:ktor-client-logging-jvm:1.6.2")
                implementation("com.google.android.material:material:1.4.0")
                implementation("androidx.core:core-ktx:1.6.0")
                implementation("io.insert-koin:koin-android:3.1.2")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:1.6.2")
                implementation("com.squareup.sqldelight:native-driver:1.5.1")
                implementation("io.ktor:ktor-client-logging-native:1.3.1")

                kotlin.srcDir("${buildDir.absolutePath}/generated/source/kaptKotlin/")
            }
        }
        val iosTest by getting
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
    }
}

sqldelight {
    database("KmmMamiDB") {
        packageName = "kr.co.kmmmami.shared.data.storage"
    }
}