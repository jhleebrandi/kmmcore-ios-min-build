package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

@Serializable
data class MyReviewListResponse(
    @SerialName( "data")
    val dataList: List<ReviewTotalData>? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()
