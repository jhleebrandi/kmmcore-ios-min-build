package kr.co.kmmmami.domain.model

import dev.icerock.moko.parcelize.Parcelize
import dev.icerock.moko.parcelize.Parcelable
import kr.co.kmmmami.domain.model.response.ProductItemSection1Data
import kr.co.kmmmami.domain.model.response.OptionData
import kr.co.kmmmami.domain.model.response.ProductItemCategoryHierarchyData
import kr.co.kmmmami.domain.model.response.ProductItemSellerData

/**
 * Created by kdy3@brandi.co.kr on 2021/05/11
 */
@Parcelize
data class OptionProductData(
    val id: String = "",
    val name: String = "",
    val seller: ProductItemSellerData? = null,
    val salePrice: Long = 0L,
    val optionType: ProductItemSection1Data.OptionType = ProductItemSection1Data.OptionType.M, // 변환 필요
    val optionList: List<OptionData> = listOf(),
    val categoryHierarchyList: List<ProductItemCategoryHierarchyData> = listOf(),
) : Parcelable
