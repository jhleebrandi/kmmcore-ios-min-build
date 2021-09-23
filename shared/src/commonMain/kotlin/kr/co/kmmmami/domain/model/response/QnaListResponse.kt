package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */

@Serializable
data class QnaListResponse(
    @SerialName( "data")
    val dataList: List<QnaData>? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class QnaData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "user")
    val user: QnaUserData? = null,
    @SerialName( "text")
    val text: String = "",
    @SerialName( "created_time")
    val createdTime: Long = 0L,
    @SerialName( "answer")
    val answer: QnaData? = null,
    @SerialName( "isAnswer")
    var isAnswer: Boolean = false,
    @SerialName( "is_secret")
    val isSecret: Boolean = false,
    @SerialName( "isVisible")
    var isVisible: Boolean = false,
    @SerialName( "isMe")
    var isMe: Boolean = false,
)

@Serializable
data class QnaUserData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
)
