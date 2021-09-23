package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class OrderCancelResponse(
    @SerialName( "data")
    val data: OrderCancelData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Parcelize
@Serializable
data class OrderCancelData(
    @SerialName( "cancel")
    val cancel: CancelData? = null,
    @SerialName( "refund")
    val refund: CancelData? = null,
    @SerialName( "section_1")
    val sectionList: List<SectionData> = emptyList(),
) : Parcelable

@Parcelize
@Serializable
data class CancelData(
    @SerialName( "type")
    val type: Int = 0,
    @SerialName( "message")
    val message: String = "",
    @SerialName( "message_info")
    val messageInfo: MessageInfoData? = null,
) : Parcelable

@Parcelize
@Serializable
data class MessageInfoData(
    @SerialName( "text")
    val text: String = "",
    @SerialName( "add_text")
    val addText: String = "",
) : Parcelable
