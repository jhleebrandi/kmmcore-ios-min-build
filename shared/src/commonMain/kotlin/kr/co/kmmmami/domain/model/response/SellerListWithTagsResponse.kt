package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by jangsc@brandi.co.kr on 12/16/20
 */
@Serializable
data class SellerListWithTagsResponse(
    @SerialName( "data")
    val data: SellerListWithTagData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class SellerListWithTagData(
    @SerialName( "sellers")
    val sellerList: List<SellerData> = emptyList(),
)
