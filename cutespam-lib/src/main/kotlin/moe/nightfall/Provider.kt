package moe.nightfall

enum class Service {
    Danbooru, Safebooru, Twitter, Konachan,
    YandeRe, Gelbooru, SankakuChannel, EShuuShuu,
    Zerochan, AnimePictures, Other
}

sealed class Provider {
    val providers = listOf(
        Direct,
        DanbooruPost,
        SafebooruPost,
        Zerochan
    )

    abstract val regex: Regex
    abstract val service: Service
    fun _fetch(url: String, match: MatchGroupCollection): CuteMeta {
        return CuteMeta(source = url) // TODO: HTTP-GET and parse
    }
    fun fetch(url: String): CuteMeta {
        return _fetch(url, regex.find(url)!!.groups)
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
}


