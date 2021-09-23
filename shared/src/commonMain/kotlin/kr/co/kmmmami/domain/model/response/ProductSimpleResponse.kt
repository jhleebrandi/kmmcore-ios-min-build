package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class ProductSimpleResponse(
    @SerialName( "data")
    val dataList: List<ProductData>? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()
