import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

fun org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler.sharedDependencies() {
//    implementation("com.github.kilianB:JImageHash:_")
    implementation("org.jsoup:jsoup:_")
    api(KotlinX.coroutines.slf4j)
}

kotlin {
    jvm()
    android()
    sourceSets {
        val commonMain by getting {

            dependencies {
                sharedDependencies()

                api(Ktor.client.cio)

                api(KotlinX.serialization.json)

                api(KotlinX.coroutines.core)

//                implementation("net.devrieze:xmlutil-serialization:_")

                // logging

                api("io.github.microutils:kotlin-logging:_")
                api("org.slf4j:slf4j-api:_") {
                    version { strictly("1.7.25") }
                }
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation(Testing.Kotest.assertions.core)
            }
        }
        val androidMain by getting {
            kotlin.srcDir("src/sharedMain/kotlin")
            dependencies {
                implementation("com.google.android.material:material:_")

              //  sharedDependencies()
                implementation("net.devrieze:xmlutil-serialization-jvm:_")

                implementation(Square.sqlDelight.drivers.android)

                implementation("com.github.tony19:logback-android:_")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13")
            }
        }
        val jvmMain by getting {
            kotlin.srcDir("src/sharedMain/kotlin")
            dependencies {
          //      sharedDependencies()

//                api(KotlinX.coroutines.jdk8)

                implementation("net.devrieze:xmlutil-serialization-jvm:_")

                implementation(Square.sqlDelight.drivers.jdbcSqlite)

                // logging
                api("ch.qos.logback:logback-classic:_")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13")
            }
        }
    }
}


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

android {
    compileSdkVersion(29)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
    }
}


sqldelight {
    database("Database") {
        packageName = "moe.nightfall.db"

//        schemaOutputDirectory = file("src/main/sqldelight/databases")
    }
}
