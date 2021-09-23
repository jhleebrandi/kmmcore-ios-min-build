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
data class CategoryResponse(
    @SerialName("data")
    val dataList: List<RootCategoryData> = emptyList(),
    @SerialName("meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class RootCategoryData(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("name")
    val name: String = "",
    @SerialName("name_eng")
    val nameEng: String = "",
    @SerialName("name_kor")
    val nameKor: String = "",
    @SerialName("image_url")
    val imageUrl: String = "",
    @SerialName("depth")
    val depth: Int = 0,
    @SerialName("categories")
    val categoryList: List<CategoryData> = emptyList(),
)

@Parcelize
@Serializable
data class CategoryData(
    @SerialName("id")
    var id: Int = 0,
    @SerialName("name")
    var name: String = "",
    @SerialName("name_eng")
    var nameEng: String = "",
    @SerialName("name_kor")
    val nameKor: String = "",
    @SerialName("image_url")
    val imageUrl: String = "",
    @SerialName("depth")
    var depth: Int = 0,
    @SerialName("order")
    val order: Int = 0,
    @SerialName("parent_id")
    var parentId: Int? = 0,
    @SerialName("product_count")
    val productCount: Int = 0,
    var rootCategoryName: String = "",
) : Parcelable

@Parcelize
@Serializable
data class CategoryPageData(
    @SerialName("data")
    val data: CategoryData,
    @SerialName("is_sale")
    val isSale: Boolean = false,
    @SerialName("is_reg")
    val isReg: Boolean = false,
    @SerialName("is_pop")
    val isPop: Boolean = false,
) : Parcelable

