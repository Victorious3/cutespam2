import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Square.sqlDelight.gradlePlugin)
    }
}
plugins {
    kotlin("jvm") apply false
    kotlin("plugin.serialization") apply false
}

subprojects {
    group = "moe.victorious3"
    version = "0.0.1-SNAPSHOT"

    repositories {
        jcenter()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    tasks.withType<KotlinCompile>() {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}

