package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class MainLuckListResponse(
    @SerialName( "data")
    val data: MainLuckListData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class MainLuckListData(
    @SerialName( "total_count")
    var totalcount: Int = 0,
    @SerialName( "time_special_price")
    var timeSpecialPrice: List<TimeSpecialPriceData> = emptyList(),
    @SerialName( "banner_image_url")
    val bannerImageUrl: String = "",
)

@Serializable
data class TimeSpecialPriceData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "image_thumbnail_url")
    val thumbnailUrl: String = "",
    @SerialName( "image_medium_url")
    val mediumImageUrl: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "price")
    val price: Long = 0L,
    @SerialName( "sale_price")
    val salePrice: Long = 0L,
    @SerialName( "sale_percent")
    val salePercent: Int = 0,
    @SerialName( "is_soldout")
    val isSoldOut: Boolean = false,
    @SerialName( "quantity")
    val quantity: Int = 0,
    @SerialName( "start_time")
    val startTime: Long = 0L,
    @SerialName( "end_time")
    val endTime: Long = 0L,
    @SerialName( "is_bookmark")
    val isBookmark: Boolean = false,
    @SerialName( "seller")
    val seller: SellerData? = null,
)
