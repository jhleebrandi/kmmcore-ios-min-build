package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by jangsc@brandi.co.kr on 12/16/20
 */
@Serializable
data class SellerWithProductsResponse(
    @SerialName( "data")
    val data: SellerWithProductsData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class SellerWithProductsData(
    @SerialName( "seller")
    val seller: ProductItemSellerData? = null,
    @SerialName( "products")
    val productList: List<ProductData> = emptyList(),
    @SerialName( "best_products")
    val bestProductList: List<ProductData> = emptyList(),
    @SerialName( "pick_products")
    val pickProductList: List<ProductData> = emptyList(),
)
