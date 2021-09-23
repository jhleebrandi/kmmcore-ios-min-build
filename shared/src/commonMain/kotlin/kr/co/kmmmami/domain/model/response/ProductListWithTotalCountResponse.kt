package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class ProductListWithTotalCountResponse(
    @SerialName( "data")
    val data: ProductListWithTotalCountData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class ProductListWithTotalCountData(
    @SerialName( "total_count")
    val totalCount: Int = 0,
    @SerialName( "store_total_count")
    val storeTotalCount: Int = 0,
    @SerialName( "products")
    val productList: List<ProductData> = emptyList(),
    @SerialName( "stores")
    val storeList: List<ProductItemSellerData> = emptyList(),
)
