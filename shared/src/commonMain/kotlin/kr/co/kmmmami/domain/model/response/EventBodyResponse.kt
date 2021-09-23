package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class EventBodyResponse(
    @SerialName( "data")
    val data: EventBodyData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class EventBodyData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "title")
    val title: String = "",
    @SerialName( "text")
    val text: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "type")
    val type: String = "",
    @SerialName( "is_answer")
    val isUseComment: Boolean = false,
    @SerialName( "is_tag")
    val isTag: Boolean = false,
    @SerialName( "coupon")
    val coupon: CouponData? = null,
    @SerialName( "html_coupon_data")
    val htmlCouponList: List<CouponDataHtml>? = emptyList(),
    @SerialName( "button")
    val button: ButtonData? = null,
    @SerialName( "products")
    val productList: List<ProductData> = emptyList(),
    @SerialName( "product_groups")
    val productGroupList: List<ProductGroupData> = emptyList(),
    @SerialName( "detail_html")
    val detailHtml: String = "",
)

@Serializable
data class ButtonData(
    @SerialName( "type")
    val type: String = "",
    @SerialName( "link")
    val link: String = "",
    @SerialName( "text")
    val text: String = "",
)

@Serializable
data class ProductGroupData(
    @SerialName( "tag")
    val tag: ProductTagData? = null,
    @SerialName( "products")
    val productList: List<ProductData> = emptyList(),
)

@Serializable
data class ProductTagData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
)
