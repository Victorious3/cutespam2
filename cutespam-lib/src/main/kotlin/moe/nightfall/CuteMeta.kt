package moe.nightfall

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

data class CuteMeta(
    val uid: UUID? = null,
    val hash: String? = null,
    val caption: String? = null,
    val authors: Set<String> = emptySet(),
    val keywords: Set<String> = emptySet(),
    val source: String? = null,
    val group_uid: UUID? = null,
    val collections: Set<String> = emptySet(),
    val rating: Rating? = null,

    val date: Date? = null,
    val last_updated: Date? = null,

    val source_other: Set<String> = emptySet(),
    val source_via: Set<String> = emptySet(),
) {
    operator fun plus(other: CuteMeta): CuteMeta {
        return copy(
            uid = other.uid ?: this.uid,
            hash = other.hash ?: this.hash,
            caption = other.caption ?: this.caption,
            authors = authors + other.authors,
            keywords = keywords + other.keywords,
            source = other.source ?: this.source,
            group_uid = other.group_uid ?: this.group_uid,
            collections = collections + other.collections,
            rating = other.rating ?: this.rating,
            date = other.date ?: this.date,
            last_updated = Date(),
            source_other = source_other + other.source_other,
            source_via = source_via + other.source_via,
        )
    }
}