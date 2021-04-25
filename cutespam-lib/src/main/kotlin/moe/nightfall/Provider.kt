package moe.nightfall

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

enum class Service(
    val provider: Provider
) {
    Danbooru(Provider.DanbooruPost),
    Safebooru(Provider.SafebooruPost),
    Zerochan(Provider.Zerochan),
    Other(Provider.Direct),
//    Twitter(Provider.WIP),
//    Konachan(Provider.WIP),
//    YandeRe(Provider.WIP),
//    Gelbooru(Provider.WIP),
//    SankakuChannel(Provider.WIP),
//    EShuuShuu(Provider.WIP),
//    AnimePictures(Provider.WIP),
    ;

    companion object {
        fun fromUrl(url: String): Service? {
            return values().firstOrNull { it.provider.regex.matches(url) }
        }
    }
}

sealed class Provider {
    abstract val regex: Regex
    abstract val service: Service
    open fun fetchAll(url: String, match: MatchGroupCollection): List<CuteMeta> {
    // TODO: HTTP-GET and parse
        return listOf(CuteMeta(source = url))
    }
    fun fetch(url: String): List<CuteMeta> {
        return fetchAll(url, regex.find(url)!!.groups)
    }


    object Direct: Provider() {
        override val service = Service.Other
        override val regex = """.*\.(jpg|png|jpeg)$""".toRegex()    // TODO Supported file extensions in config
    }

    object DanbooruPost: Provider() {
        override val service = Service.Danbooru
        override val regex = """.*danbooru.donmai.us/posts/(?<id>[\d]+)""".toRegex()
    }

    object SafebooruPost: Provider() {
        override val service = Service.Safebooru
        override val regex = """.*safebooru.org.*(id=(?<id>[\d]+)).*""".toRegex()
    }

    object Zerochan: Provider() {
        override val service = Service.Zerochan
        override val regex = """.*zerochan.net/(full/)?(?<id>[\d]+)""".toRegex()
    }

    companion object {
        fun fetchMatching(url: String): List<CuteMeta> {
            val service = Service.fromUrl(url) ?: run {
                logger.error { "no service matched" }
                return emptyList()
            }
            return service.provider.fetch(url)
        }
    }
}


