package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class MainListResponse(
    @SerialName( "data")
    val data: MainListData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class MainListData(
    @SerialName("top_banners")
    val topBannerList: List<BannerListData> = emptyList(),
    @SerialName("thin_banners")
    val thinBannerList: List<BannerListData> = emptyList(),
    @SerialName("main_banners")
    val mainBannerList: List<BannerListData> = emptyList(),
    @SerialName("content_banners")
    val contentBannerList: List<BannerListData> = emptyList(),
    @SerialName("nonmember")
    val nonmember: NonMemberData? = null,
    @SerialName("zoning_1")
    val zoning1: List<MainZoningData> = emptyList(),
    @SerialName("zoning_2")
    val zoning2: List<MainZoningData> = emptyList(),
    @SerialName("zoning_3")
    val zoning3: List<MainZoningData> = emptyList(),
    @SerialName("button_zoning")
    val buttonZoning: List<MainZoningData> = emptyList(),
    @SerialName("ranking_products")
    val rankingProductList: List<ProductData> = emptyList(),
    @SerialName("sub_banners_1")
    val subBannersList1: List<BannerListData> = emptyList(),
    @SerialName("sub_banners_2")
    val subBannersList2: List<BannerListData> = emptyList(),
    @SerialName("recommend_products")
    val recommendProductList: List<ProductData> = emptyList(),
    @SerialName("best_products")
    val bestProductList: List<ProductData> = emptyList(),
    @SerialName("sellers")
    val sellerList: List<SellerData> = emptyList(),
    @SerialName("hot_products")
    val hotProductList: List<ProductData> = emptyList(),
    @SerialName("category_products")
    val categoryProductList: List<CategoryProductData> = emptyList(),
    @SerialName("tag_products")
    val tagProductList: TagProductData? = null,
    @SerialName("middle_zoning")
    val middleZoning: MiddleZoningData? = null,
    @SerialName("content_zoning")
    val contentZoning: ContentZoningData? = null,
    @SerialName("brand_zoning")
    val brandZoning: BrandZoningData? = null,
    @SerialName("hot_deal_zoning")
    val hotDealZoning: HotDealZoningData? = null
)

@Serializable
data class MiddleZoningData(
    @SerialName("name")
    val name: String = "",
    @SerialName("link")
    val link: LinkData? = null,
    @SerialName("banners")
    val banners: List<BannerListData> = emptyList()
)

@Serializable
data class ContentZoningData(
    @SerialName("name")
    val name: String = "",
    @SerialName("link")
    val link: LinkData? = null,
    @SerialName("banners")
    val banners: List<BannerListData> = emptyList()
)

@Serializable
data class NonMemberData(
    @SerialName("thin_banners")
    val thinBannerList: List<BannerListData> = emptyList(),
)

@Serializable
data class MainZoningData(
    @SerialName("id")
    val id: String = "",
    @SerialName("name")
    val name: String = "",
    @SerialName("text")
    val text: String = "",
    @SerialName("link")
    val link: LinkData? = null,
    @SerialName("tags")
    val tagList: List<MainZoningTagData> = emptyList(),
    @SerialName("products")
    val productList: List<ProductData> = emptyList(),
)

@Serializable
data class LinkData(
    @SerialName("type")
    val type: String = "",
    @SerialName("value")
    val value: String = "",
)

@Serializable
data class MainZoningTagData(
    @SerialName("id")
    val id: String = "",
    @SerialName("name")
    val name: String = "",
    @SerialName("products")
    val productList: List<ProductData> = emptyList(),
)

@Serializable
data class CategoryProductData(
    @SerialName("category")
    val category: MainListCategoryData? = null,
    @SerialName("products")
    val productList: List<ProductData> = emptyList(),
)

@Serializable
data class TagProductData(
    @SerialName("text")
    val text: String = "",
    @SerialName("products")
    val productList: List<ProductData> = emptyList(),
)

@Serializable
data class MainListCategoryData(
    @SerialName("id")
    val id: String = "",
    @SerialName("name")
    val name: String = "",
)

@Serializable
data class BrandZoningData(
    @SerialName("title")
    val title: String = "",
    @SerialName("image_url")
    val imageUrl: String = "",
    @SerialName("link")
    val link: LinkData? = null,
    @SerialName("products")
    val products: List<ProductData> = emptyList()
)

@Serializable
data class HotDealZoningData(
    @SerialName("coming_soon")
    val comingSoon: ComingSoon? = null,
    @SerialName("hot_deal")
    val hotDealData: HotDealData? = null
)

@Serializable
data class HotDealData(
    @SerialName("end_time")
    val endTime: String = "",
    @SerialName("info")
    val hotDealInfoList: List<HotDealInfo> = emptyList(),
    @SerialName("start_time")
    val startTime: String = "",
    @SerialName("title")
    val title: String = ""
)

@Serializable
data class HotDealInfo(
    @SerialName("expect_sale_price")
    val expectSalePrice: Long = 0L,
    @SerialName("expect_sale_percent")
    val expectSalePercent: Int = 0,
    @SerialName("image_url")
    val imageUrl: String = "",
    @SerialName("is_expect_sale_price")
    val isExpectSalePrice: Boolean = false,
    @SerialName("is_soldout")
    val isSoldOut: Boolean = false,
    @SerialName("link")
    val link: LinkData? = null,
    @SerialName("MD")
    val mdInfo: MDInfo? = null,
    @SerialName("name")
    val name: String = "",
    @SerialName("price")
    val price: Long = 0L,
    @SerialName("sale_percent")
    val salePercent: Int = 0,
    @SerialName("sale_price")
    val salePrice: Long = 0L
)

@Serializable
data class MDInfo(
    @SerialName("comment")
    val comment: String = "",
    @SerialName("image_url")
    val imageUrl: String = "",
    @SerialName("profile")
    val profile: String = ""
)

@Serializable
data class ComingSoon(
    @SerialName("end_time")
    val endTime: String = "",
    @SerialName("info")
    val info: List<ComingInfo> = emptyList(),
    @SerialName("start_time")
    val startTime: String = ""
)

@Serializable
data class ComingInfo(
    @SerialName("image_url")
    val imageUrl: String = "",
    @SerialName("name")
    val name: String = ""
)
