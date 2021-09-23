package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by jangsc@brandi.co.kr on 12/16/20
 */
@Serializable
data class SellerListResponse(
    @SerialName( "data")
    val dataList: List<SellerData>? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class SellerData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "en_name")
    val englishName: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "text")
    val text: String = "",
    @SerialName( "is_bookmark")
    val isBookMark: Boolean = false,
    @SerialName( "isDbBookMark")
    var isDbBookMark: Boolean = false,
    @SerialName( "bookmark_count")
    val bookmarkCount: Int = 0,
    @SerialName( "tags")
    val tagList: List<SellerTagData> = emptyList(),
    @SerialName( "products")
    val productList: List<ProductData> = emptyList(),
    @SerialName( "type")
    val type: SellerTypeData? = null,
    @SerialName( "rank")
    val rank: Int = 0,
)

@Serializable
data class SellerTagData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
)
