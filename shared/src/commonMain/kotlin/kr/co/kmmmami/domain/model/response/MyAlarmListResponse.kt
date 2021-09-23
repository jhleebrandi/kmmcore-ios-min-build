package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response
import kr.co.kmmmami.domain.model.SectionGroupData

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class MyAlarmListResponse(
    @SerialName( "data")
    val dataList: List<MyAlarmListData>? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class MyAlarmListData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "heading")
    val heading: String = "",
    @SerialName( "text")
    val text: String = "",
    @SerialName( "link_type")
    val linkType: String = "",
    @SerialName( "seller")
    val seller: MyAlarmSellerData? = null,
    @SerialName( "product")
    val product: MyAlarmProductData? = null,
    @SerialName( "created_time")
    val createdTime: Long = 0L,
    @SerialName( "button_type")
    val buttonType: String = "",
)

@Serializable
data class MyAlarmSellerData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "type")
    val type: TypeData? = null,
    @SerialName( "section_group")
    val sectionGroup: SectionGroupData? = null,
)

@Parcelize
@Serializable
data class MyAlarmProductData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "parent_id")
    val parentId: String = "",
    @SerialName( "brand_id")
    val brandId: String = "",
    @SerialName( "image_thumbnail_url")
    val thumbnailUrl: String = "",
    @SerialName( "sale_price")
    val salePrice: String = "",
    @SerialName( "category_id")
    val categoryId: String = "",
    @SerialName( "option_name")
    val optionName: String = "",
    @SerialName( "is_cloth")
    val isCloth: Boolean = false
) : Parcelable
