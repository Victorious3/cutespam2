package moe.nightfall.danbooru

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import mu.KotlinLogging
import java.net.http.HttpClient

object DanbooruTest {
    private val logger = KotlinLogging.logger {}
    @JvmStatic
    fun main(args: Array<String>): Unit = runBlocking {
        val client = HttpClient(CIO) {

        }

        val json = Json {
            ignoreUnknownKeys = true
        }

        val postJson = client.get<String>("https://danbooru.donmai.us/posts/4434398.json")
        val post = json.decodeFromString(Post.serializer(), postJson)

        logger.info { "post parsed" }
        logger.info { post }

        logger.info { "general tags:" }
        post.tagsGeneral.forEach { tag ->
            logger.info { "* $tag" }
        }
        logger.info { "character tags:" }
        post.tagsCharacter.forEach { tag ->
            logger.info { "* $tag" }
        }
        logger.info { "artist tags:" }
        post.tagsArtist.forEach { tag ->
            logger.info { "* $tag" }
        }
        logger.info { "copyright tags:" }
        post.tagsCopyright.forEach { tag ->
            logger.info { "* $tag" }
        }
        logger.info { "meta tags:" }
        post.tagsMeta.forEach { tag ->
            logger.info { "* $tag" }
        }
    }
}