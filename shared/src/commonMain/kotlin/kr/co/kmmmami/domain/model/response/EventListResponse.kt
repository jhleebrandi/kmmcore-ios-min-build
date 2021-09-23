package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class EventListResponse(
    @SerialName( "data")
    val dataList: List<EventData>? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class EventData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "image_url")
    val imageUrl: String? = null,
    @SerialName( "type")
    val type: String = "",
    @SerialName( "link")
    val link: String = "",
    @SerialName( "title")
    val title: String = "",
    @SerialName( "sub_title")
    val subTitle: String = "",
    @SerialName( "is_square_ratio")
    val isSquareRatio: Boolean = false,
    @SerialName( "coupon")
    val coupon: CouponData? = null,
)
