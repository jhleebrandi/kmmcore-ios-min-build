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
data class OrderRequestCancelResponse(
    @SerialName( "data")
    val data: OrderRequestCancelData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class OrderRequestCancelData(
    @SerialName( "cancel")
    val refund: RefundData? = null,
    @SerialName( "reasons")
    val reasonList: List<ReasonData> = emptyList(),
    @SerialName( "banks")
    val bankList: List<BankData> = emptyList(),
    @SerialName( "section_1")
    val sectionList: List<SectionData> = emptyList(),
)

@Serializable
data class RefundData(
    @SerialName( "type")
    val type: Int = 0,
)

@Serializable
data class ReasonData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "text")
    val text: String = "",
)

@Serializable
data class BankData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
)

@Parcelize
@Serializable
data class SectionData(
    @SerialName( "key")
    var key: String = "",
    @SerialName( "text")
    var text: String? = null,
    @SerialName( "description")
    val description: String = "",
    @SerialName( "style")
    var style: String? = null,
    @SerialName( "text_color")
    var textColor: String = "",
) : Parcelable
