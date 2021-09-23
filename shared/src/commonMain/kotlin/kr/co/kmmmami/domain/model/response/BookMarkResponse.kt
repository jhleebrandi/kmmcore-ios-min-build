package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class BookMarkResponse(
    @SerialName( "data")
    val data: BookMarkData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null
) : Response()

@Serializable
data class BookMarkData(
    @SerialName("bookmark_count")
    val bookMarkCount: Int = 0,
    @SerialName("seller")
    val seller: BookMarkSellerData? = null,
    @SerialName("category_hierarchies")
    val categoryHierarchyList: List<ProductItemCategoryHierarchyData> = emptyList()
)

@Serializable
data class BookMarkSellerData(
    @SerialName("is_partner")
    val isPartner: Boolean = false,
    @SerialName("type")
    val type: TypeData? = null
)

data class StoreBookMarkResponse(
    @SerialName("meta")
    override val meta: Meta? = null,
    @SerialName("data")
    val StoreBookMarkList: StoreBookMarkList
) : Response()

data class StoreBookMarkList(
    @SerialName("success_list")
    val successList: List<SellerData> = emptyList(),
    @SerialName("fail_list")
    val failList: List<SellerData> = emptyList()
)
