import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    dependencies {
        classpath(Square.sqlDelight.gradlePlugin)
        classpath("com.android.tools.build:gradle:_")
        classpath("org.jetbrains.compose:compose-gradle-plugin:_")
    }
}
plugins {
    kotlin("multiplatform") apply false
    kotlin("plugin.serialization") apply false
}

subprojects {
    group = "moe.nightfall"
    version = "0.0.1-SNAPSHOT" // TODO: load from properties or so

    repositories {
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
//        maven("https://nikky.moe/maven")
        jcenter()
        // TODO: hope this ends up on central or rehost
        maven("https://dl.bintray.com/pdvrieze/maven")
    }

    tasks.withType<KotlinCompile>() {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

