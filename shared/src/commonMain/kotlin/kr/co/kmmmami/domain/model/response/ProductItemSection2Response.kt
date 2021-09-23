package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class ProductItemSection2Response(
    @SerialName( "data")
    val data: ProductItemSection2Data? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class ProductItemSection2Data(
    @SerialName( "popular_category_id")
    val popularCategoryId: String = "",
    @SerialName( "popular_category_name")
    val popularCategoryName: String = "",
    @SerialName( "popular_category_products")
    val popularCategoryProductList: List<ProductData> = emptyList(),
    @SerialName( "seller")
    val seller: ProductItemSellerData? = null,
)
