package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelize
import dev.icerock.moko.parcelize.Parcelable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class CommentListResponse(
    @SerialName( "data")
    val dataList: List<CommentData>? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Parcelize
@Serializable
data class CommentData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "text")
    val text: String = "",
    @SerialName( "user")
    val user: CommentUserData? = null,
    @SerialName( "created_time")
    val createdTime: Long = 0L,
) : Parcelable

@Parcelize
@Serializable
data class CommentUserData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
) : Parcelable
