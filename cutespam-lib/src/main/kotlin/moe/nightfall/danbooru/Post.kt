package moe.nightfall.danbooru

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Post(
    @SerialName("id") val id : Int,
    @SerialName("created_at") val created_at : String,
    @SerialName("uploader_id") val uploader_id : Int,
    @SerialName("score") val score : Int,
    @SerialName("source") val source : String,
    @SerialName("md5") val md5 : String,
    @SerialName("last_comment_bumped_at") val last_comment_bumped_at : String?,
    @SerialName("rating") val rating : String,
    @SerialName("image_width") val image_width : Int,
    @SerialName("image_height") val image_height : Int,
    @SerialName("tag_string") val tag_string : String,
    @SerialName("is_note_locked") val is_note_locked : Boolean,
    @SerialName("fav_count") val fav_count : Int,
    @SerialName("file_ext") val file_ext : String,
    @SerialName("last_noted_at") val last_noted_at : String?,
    @SerialName("is_rating_locked") val is_rating_locked : Boolean,
    @SerialName("parent_id") val parent_id : Int?,
    @SerialName("has_children") val has_children : Boolean,
    @SerialName("approver_id") val approver_id : Int?,
    @SerialName("tag_count_general") val tag_count_general : Int,
    @SerialName("tag_count_artist") val tag_count_artist : Int,
    @SerialName("tag_count_character") val tag_count_character : Int,
    @SerialName("tag_count_copyright") val tag_count_copyright : Int,
    @SerialName("file_size") val file_size : Int,
    @SerialName("is_status_locked") val is_status_locked : Boolean,
    @SerialName("pool_string") val pool_string : String,
    @SerialName("up_score") val up_score : Int,
    @SerialName("down_score") val down_score : Int,
    @SerialName("is_pending") val is_pending : Boolean,
    @SerialName("is_flagged") val is_flagged : Boolean,
    @SerialName("is_deleted") val is_deleted : Boolean,
    @SerialName("tag_count") val tag_count : Int,
    @SerialName("updated_at") val updated_at : String,
    @SerialName("is_banned") val is_banned : Boolean,
    @SerialName("pixiv_id") val pixiv_id : Int?,
    @SerialName("last_commented_at") val last_commented_at : String?,
    @SerialName("has_active_children") val has_active_children : Boolean,
    @SerialName("bit_flags") val bit_flags : Int,
    @SerialName("tag_count_meta") val tag_count_meta : Int,
    @SerialName("has_large") val has_large : Boolean,
    @SerialName("has_visible_children") val has_visible_children : Boolean,
    @SerialName("tag_string_general") val tag_string_general : String,
    @SerialName("tag_string_character") val tag_string_character : String,
    @SerialName("tag_string_copyright") val tag_string_copyright : String,
    @SerialName("tag_string_artist") val tag_string_artist : String,
    @SerialName("tag_string_meta") val tag_string_meta : String,
    @SerialName("file_url") val file_url : String,
    @SerialName("large_file_url") val large_file_url : String,
    @SerialName("preview_file_url") val preview_file_url : String
) {
    val tags: List<String> get() = tag_string.split(' ')
    val tagsGeneral: List<String> get() = tag_string_general.split(' ')
    val tagsCharacter: List<String> get() = tag_string_character.split(' ')
    val tagsCopyright: List<String> get() = tag_string_copyright.split(' ')
    val tagsArtist: List<String> get() = tag_string_artist.split(' ')
    val tagsMeta: List<String> get() = tag_string_meta.split(' ')
}