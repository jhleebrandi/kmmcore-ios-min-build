package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */

@Serializable
data class ProductBookMarkListResponse(
    @SerialName( "data")
    val data: ProductBookMarkListData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class ProductBookMarkListData(
    @SerialName( "categoryGroups")
    val categoryGroupList: List<CategoryGroupData> = emptyList(),
    @SerialName( "products")
    val productList: List<ProductData> = emptyList(),
)

@Parcelize
@Serializable
data class CategoryGroupData(
    @SerialName( "id")
    val id: Int = 0,
    @SerialName( "name_kor")
    val koreanName: String = "",
    @SerialName( "name_eng")
    val englishName: String = "",
    @SerialName( "order")
    val order: Int = 0,
) : Parcelable
