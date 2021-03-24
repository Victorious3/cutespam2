plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib", "_"))
    // https://mvnrepository.com/artifact/com.github.kilianB/JImageHash
    implementation("com.github.kilianB:JImageHash:_")
}

//tasks.withType<KotlinCompile>() {
//    kotlinOptions.jvmTarget = "11"
//}
