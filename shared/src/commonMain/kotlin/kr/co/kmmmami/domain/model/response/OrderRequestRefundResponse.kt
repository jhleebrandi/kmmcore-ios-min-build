package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

@Serializable
data class OrderRequestRefundResponse(
    @SerialName( "data")
    val data: OrderRequestRefundData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class OrderRequestRefundData(
    @SerialName( "refund")
    val refund: RefundData? = null,
    @SerialName( "reasons")
    val reasonList: List<ReasonData> = emptyList(),
    @SerialName( "banks")
    val bankList: List<BankData> = emptyList(),
    @SerialName( "section_1")
    val sectionList: List<SectionData> = emptyList(),
)
