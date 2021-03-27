
plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.squareup.sqldelight")
}

dependencies {
    implementation(kotlin("stdlib", "_"))
    // https://mvnrepository.com/artifact/com.github.kilianB/JImageHash
    implementation("com.github.kilianB:JImageHash:_")
    implementation("org.jsoup:jsoup:_")

    api(Ktor.client.cio)

    api(KotlinX.serialization.json)

    api(KotlinX.coroutines.core)
    api(KotlinX.coroutines.jdk8)

    // TODO: use -android on android
    implementation("net.devrieze:xmlutil-serialization-jvm:_")

    implementation(Square.sqlDelight.drivers.jdbcSqlite)
//    implementation(Square.sqlDelight.coroutinesExtensions) // seems to miss `:_`
    implementation("com.squareup.sqldelight:coroutines-extensions:_")

    api("io.github.microutils:kotlin-logging:_")
    api("ch.qos.logback:logback-classic:_")
    api("org.slf4j:slf4j-api:_") {
        version { strictly("1.7.25") }
    }

    testImplementation(platform("org.junit:junit-bom:5.7.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.kotest:kotest-assertions-core:_")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}


//tasks.withType<KotlinCompile>() {
//    kotlinOptions.jvmTarget = "11"
//}

sqldelight {
    database("Database") {
        packageName = "moe.nightfall.db"

//        schemaOutputDirectory = file("src/main/sqldelight/databases")
    }
}