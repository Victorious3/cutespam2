package com.example.myapplication.shared

actual class Platform actual constructor() {
    actual val platform: String = "JVM ${11}"
}