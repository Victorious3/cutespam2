package moe.nightfall

import java.lang.IllegalArgumentException
import java.time.LocalDateTime
import java.util.*

enum class Rating(val rating: String) {
    Safe("s"),
    Nudity("n"),
    Questionable("q"),
    Explicit("e");

    companion object {
        fun ratingOf(rating: String): Rating {
            return values().find { it.rating == rating } ?: throw IllegalArgumentException()
        }
    }
}

class CuteMeta(
    var uid: UUID? = null,
    var hash: String? = null,
    var caption: String? = null,
    var authors: MutableSet<String> = mutableSetOf(),
    var keywords: MutableSet<String> = mutableSetOf(),
    var source: String? = null,
    var group_uid: UUID? = null,
    var collections: MutableSet<String> = mutableSetOf(),
    var rating: Rating? = null,

    var date: Date? = null,
    var last_updated: Date? = null,

    var source_other: MutableSet<String> = mutableSetOf(),
    var source_via: MutableSet<String> = mutableSetOf()
) {
    fun plusAssign(other: CuteMeta) {
        this.uid = other.uid ?: this.uid
        this.hash = other.hash ?: this.hash
        this.caption = other.caption ?: this.caption
        this.authors.addAll(other.authors)
        this.keywords.addAll(other.keywords)
        this.source = other.source ?: this.source
        this.group_uid = other.group_uid ?: this.group_uid
        this.collections.addAll(other.collections)
        this.rating = other.rating ?: this.rating
        this.date = other.date ?: this.date
        this.last_updated = Date()
        this.source_other.addAll(other.source_other)
        this.source_via.addAll(other.source_via)
    }
}