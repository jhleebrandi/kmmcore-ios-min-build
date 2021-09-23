package kr.co.kmmmami.domain.model.request

import kotlinx.serialization.Serializable

/**
 * Created by parkkks2@brandi.co.kr on 2021/01/25
 */
@Serializable
data class SearchProductRequest(
    val offset: Int?,
    val limit: Int,
    val isSale: Boolean?,
    val orderFilter: String?,
    val storeRootCategoryId: String?,
    val priceFilterMap: HashMap<String, String>?,
    val saleFilterMap: HashMap<String, String>?,
    val ranking: String?
)
