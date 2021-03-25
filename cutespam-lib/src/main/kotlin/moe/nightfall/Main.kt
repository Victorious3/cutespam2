package moe.nightfall

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import moe.nightfall.db.Database
import mu.KotlinLogging
import java.io.File

private val logger = KotlinLogging.logger("cutespam")

fun main() {

//    val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
    val databaseFile = File("db.sqlite")
    val runMigrations = databaseFile.exists()
    val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:${databaseFile.path}")
    logger.info("current schema version: ${Database.Schema.version}")
    val database = Database(driver)

    if (runMigrations) {
        val oldSchemaVersion = database.schemaQueries.getCurrent().executeAsOne().last?.toInt() ?: 0
        Database.Schema.migrate(driver, oldSchemaVersion, Database.Schema.version)
        database.schemaQueries.setCurrent(Database.Schema.version)
    } else {
        logger.info("creating database")
        Database.Schema.create(driver)
        database.schemaQueries.setCurrent(Database.Schema.version)
    }
}