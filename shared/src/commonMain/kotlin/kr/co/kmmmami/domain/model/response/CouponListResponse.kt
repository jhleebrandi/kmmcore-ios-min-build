package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class CouponListResponse(
    @SerialName( "data")
    val dataList: List<CouponData>? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Parcelize
@Serializable
data class CouponData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "title")
    val title: String = "",
    @SerialName( "sub_title")
    val subTitle: String? = null,
    @SerialName( "name")
    var name: String = "",
    @SerialName( "order_no")
    var orderNumber: String? = null,
    @SerialName( "badge_text")
    val badgeText: String = "",
    @SerialName( "apply_target")
    val applyTarget: ApplyTargetData? = null,
    @SerialName( "sale")
    val sale: SaleData? = null,
    @SerialName( "state")
    var state: Int = 0,
    @SerialName( "validity")
    val validity: ValidityData? = null,
    @SerialName( "validity_start_time")
    val validityStartTime: String = "",
    @SerialName( "validity_end_time")
    val validityEndTime: String = "",
    @SerialName( "condition_subText")
    val conditionSubText: String? = null,
    @SerialName( "condition_text2")
    val conditionText2: String = "",
    @SerialName( "created_time")
    val createdTime: String = "",
    @SerialName( "is_all_product")
    val isAllProduct: Boolean = false,
    @SerialName( "product_ids")
    val productIdList: List<String>? = null,
    @SerialName( "target")
    val target: TargetData? = null,
    @SerialName( "is_limit_max_price")
    val isLimitMaxPrice: Boolean? = null,
    @SerialName( "limit_max_price")
    val limitMaxPrice: Int? = null,
    @SerialName( "is_first_purchase_benefit")
    val isFirstPurchaseBenefit: Boolean? = null,
    @SerialName( "is_limit_order_price")
    val isLimitOrderPrice: Boolean? = null
) : Parcelable

@Parcelize
@Serializable
data class CouponDataHtml(
    @SerialName( "value")
    val value: String? = null,
    @SerialName( "list")
    val list: String? = null
) : Parcelable

@Parcelize
@Serializable
data class SaleData(
    @SerialName( "type")
    val type: String = "",
    @SerialName( "value")
    val value: Long = 0L
) : Parcelable {
    fun getEnumType(): TYPE_SALE {
        return TYPE_SALE.valueOf(type.toUpperCase())
    }
}

enum class TYPE_SALE {
    PRICE, RATE
}

@Parcelize
@Serializable
data class TargetData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
) : Parcelable

@Parcelize
@Serializable
data class ValidityData(
    @SerialName( "period")
    val period: PeriodData? = null,
    @SerialName( "text")
    val text: String = "",
    @SerialName( "type")
    val type: String = "",
) : Parcelable

@Parcelize
@Serializable
data class PeriodData(
    @SerialName( "type")
    val type: String = "",
    @SerialName( "value")
    val value: Long = 0L
) : Parcelable

@Parcelize
@Serializable
data class ApplyTargetData(
    @SerialName( "badge_text")
    val badgeText: String = "",
    @SerialName( "condition_subtext")
    val conditionSubText: String? = null,
    @SerialName( "condition_text2")
    val conditionText2: String = "",
    @SerialName( "link")
    val link: ApplyTargetLinkData? = null,
    @SerialName( "created_time")
    val createdTime: String = "",
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
) : Parcelable

@Parcelize
@Serializable
data class ApplyTargetLinkData(
    @SerialName( "type")
    val type: String = "",
    @SerialName( "value")
    val value: String = "",
) : Parcelable
