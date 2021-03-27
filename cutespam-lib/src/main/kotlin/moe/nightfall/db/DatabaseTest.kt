package moe.nightfall

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import moe.nightfall.db.Database
import mu.KotlinLogging
import mu.withLoggingContext
import java.io.File

private val logger = KotlinLogging.logger("cutespam")

fun main() {
    withLoggingContext("main" to "DatabaseTest") {
        val databaseFile = File("db.sqlite")
        val fileExists = databaseFile.exists()
        val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:${databaseFile.path}")
        logger.info { "current schema version: ${Database.Schema.version}" }
        val database = Database(driver)

        if (!fileExists) {
            logger.info { "creating database schema" }
            Database.Schema.create(driver)

            logger.info { "inserting data" }
            database.hockerPlayerQueries.insert(1, "Some Player")
            database.hockerPlayerQueries.insert(2, "Other player")
        }

        database.hockerPlayerQueries.selectAll().executeAsList().forEach { player ->
            logger.info { player }
        }
    }
}