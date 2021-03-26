package moe.nightfall

import java.io.File

data class IqdbResult(
    val service: Service,
    val similarity: Float,
    val url: String,
    val rating: Rating,
    val size: Pair<Int, Int>
)

fun iqdb(file: File): List<IqdbResult> {
    return listOf()
}

fun iqdb(url: String): List<IqdbResult> {
    return listOf()
}