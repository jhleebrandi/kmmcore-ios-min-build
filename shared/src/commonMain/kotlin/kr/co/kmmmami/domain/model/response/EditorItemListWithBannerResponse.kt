package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class EditorItemListWithBannerResponse(
    @SerialName( "data")
    val data: EditorItemListWithBannerData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class EditorItemListWithBannerData(
    @SerialName( "items")
    val itemList: List<EditorItemData> = emptyList(),
)

@Serializable
data class EditorItemData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "brand_id")
    val brandId: String = "",
    @SerialName( "image_thumbnail_url")
    val thumbnailUrl: String = "",
    @SerialName( "image_medium_url")
    val imageMediumUrl: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "created_time")
    val createdTime: String = "",
    @SerialName( "user")
    val user: EditorItemUserData? = null,
)

@Serializable
data class EditorItemUserData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
)
