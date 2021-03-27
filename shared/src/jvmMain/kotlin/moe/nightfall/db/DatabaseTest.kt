package moe.nightfall.db

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import moe.nightfall.db.Database
import mu.KotlinLogging
import java.io.File

private val logger = KotlinLogging.logger {}

fun main() {

//    val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
    val databaseFile = File("db.sqlite")
    val fileExists = databaseFile.exists()
    val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:${databaseFile.path}")
    logger.info { "current schema version: ${Database.Schema.version}" }
    val database = Database(driver)

    if (!fileExists) {
        logger.info { "creating database schema" }
        Database.Schema.create(driver)
    }
}