
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

    implementation(Square.sqlDelight.drivers.jdbcSqlite)
//    implementation(Square.sqlDelight.coroutinesExtensions) // seems to miss `:_`
    implementation("com.squareup.sqldelight:coroutines-extensions:_")

    api("io.github.microutils:kotlin-logging:_")
    api("ch.qos.logback:logback-classic:_")
}

//tasks.withType<KotlinCompile>() {
//    kotlinOptions.jvmTarget = "11"
//}

sqldelight {
    database("Database") {
        packageName = "moe.nightfall.db"
        deriveSchemaFromMigrations = true

//        schemaOutputDirectory = file("src/main/sqldelight/databases")
    }
}