package kr.co.kmmmami.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.json.JsonObject
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.core_data.model.RootData
import kr.co.kmmmami.domain.model.request.OrderBodyRequest
import kr.co.kmmmami.domain.model.response.*

interface MarketRepository {
    suspend fun getMainFashion(
        token: String
    ): Flow<ResultData<MainListResponse>>

    suspend fun getMainBaby(
        token: String
    ): Flow<ResultData<MainListResponse>>

    suspend fun getMainLife(
        token: String
    ): Flow<ResultData<MainListResponse>>

    suspend fun getMainInfant(
        token: String
    ): Flow<ResultData<MainListResponse>>

    suspend fun getMainMaternity(
        token: String
    ): Flow<ResultData<MainListResponse>>

    suspend fun getCategoryProductList(
        token: String,
        categoryId: String,
        offset: Int,
        isSale: Boolean,
        order: String,
        priceFilterMap: HashMap<String, String>?,
        saleFilterMap: HashMap<String, String>?,
    ): Flow<ResultData<ProductListResponse>>

    suspend fun getFashionAllProductList(
        token: String,
        offset: Int,
        isSale: Boolean,
        order: String,
        priceFilterMap: HashMap<String, String>?,
        saleFilterMap: HashMap<String, String>?,
    ): Flow<ResultData<ProductListResponse>>

    suspend fun getBabyAllProductList(
        token: String,
        offset: Int,
        isSale: Boolean,
        order: String,
        priceFilterMap: HashMap<String, String>?,
        saleFilterMap: HashMap<String, String>?,
    ): Flow<ResultData<ProductListResponse>>

    suspend fun getLifeAllProductList(
        token: String,
        offset: Int,
        isSale: Boolean,
        order: String,
        priceFilterMap: HashMap<String, String>?,
        saleFilterMap: HashMap<String, String>?,
    ): Flow<ResultData<ProductListResponse>>

    suspend fun getInfantAllProductList(
        token: String,
        offset: Int,
        isSale: Boolean,
        order: String,
        priceFilterMap: HashMap<String, String>?,
        saleFilterMap: HashMap<String, String>?,
    ): Flow<ResultData<ProductListResponse>>

    suspend fun getMaternityAllProductList(
        token: String,
        offset: Int,
        isSale: Boolean,
        order: String,
        priceFilterMap: HashMap<String, String>?,
        saleFilterMap: HashMap<String, String>?,
    ): Flow<ResultData<ProductListResponse>>

    suspend fun getMyBanners(
        token: String,
    ): Flow<ResultData<MyBannersResponse>>

    suspend fun getAlarms(
        token: String,
        lt: String = "",
    ): Flow<ResultData<MyAlarmListResponse>>

    suspend fun postAlarmsDefault(
        token: String,
    ): Flow<ResultData<MyAlarmListResponse>>

    suspend fun getProductInfo(
        token: String,
        productId: String,
    ): Flow<ResultData<ProductItemSection1Response>>

    suspend fun getProductsInquiriesWithCount(
        token: String,
        productId: String,
        isOnlyMyQa: Boolean,
    ): Flow<ResultData<QnaListWithTotalCountResponse>>

    suspend fun postProductsInquiries(
        token: String,
        productId: String,
        jsonObject: JsonObject,
    ): Flow<ResultData<RootData>>

    suspend fun getProductSection2Info(
        token: String,
        productId: String,
    ): Flow<ResultData<ProductItemSection2Response>>

    suspend fun postProductsBookmark(
        token: String,
        id: String,
    ): Flow<ResultData<BookMarkResponse>>

    suspend fun deleteProductsBookmark(
        token: String,
        id: String,
    ): Flow<ResultData<BookMarkResponse>>

    suspend fun getUserSelfProducts(
        token: String,
        offset: Int,
        categoryGroupId: String,
        isSoldOut: Boolean,
        orderFilter: String,
    ): Flow<ResultData<ProductListResponse>>

    suspend fun getUserSelfProductsByCategoryGroups(
        token: String,
        offset: Int = 0,
        categoryGroupId: String,
        isSoldOut: Boolean,
        orderFilter: String,
    ): Flow<ResultData<ProductBookMarkListResponse>>

    suspend fun getUserSelfSellers(
        token: String,
        offset: Int = 0,
    ): Flow<ResultData<SellerListResponse>>

    suspend fun deleteStoreBookmark(
        token: String,
        sellerId: String,
    ): Flow<ResultData<RootData>>

    suspend fun postStoreBookmark(
        token: String,
        sellerId: String,
    ): Flow<ResultData<RootData>>

    suspend fun postStoreBookmarkList(
        token: String,
        sellers: List<String>
    ): Flow<ResultData<StoreBookMarkResponse>>

    suspend fun postCouponDownload(
        token: String,
        jsonObject: JsonObject,
    ): Flow<ResultData<CouponDownloadResponse>>

    suspend fun getTagsProduct(
        token: String,
        id: String,
        lastItemId: String = "",
    ): Flow<ResultData<ProductListResponse>>

    suspend fun getTagsProductByName(
        token: String,
        tagName: String,
        lastItemId: String = "",
    ): Flow<ResultData<ProductListResponse>>

    suspend fun getSellersMain(
        token: String,
        offset: Int = 0,
        tabPosition: String,
        orderFilter: String,
    ): Flow<ResultData<SellerListResponse>>

    suspend fun getOrdersTemporary(
        token: String,
        orderType: String,
        productId: String,
        productQty: String,
    ): Flow<ResultData<OrderTemporaryResponse>>

    suspend fun postDeliveryAddresses(
        token: String,
        jsonObject: JsonObject,
    ): Flow<ResultData<DeliveryAddressListResponse>>

    suspend fun putDeliveryAddresses(
        token: String,
        addressId: String,
        jsonObject: JsonObject,
    ): Flow<ResultData<DeliveryAddressResponse>>

    suspend fun getDeliveryAddresses(
        token: String,
        map: HashMap<String, String>,
    ): Flow<ResultData<DeliveryAddressListResponse>>

    suspend fun deleteDeliveryAddresses(
        token: String,
        addressId: String,
    ): Flow<ResultData<RootData>>

    suspend fun postDeliveryAddressesIdRequestInfo(
        token: String,
        addressId: String,
        jsonObject: JsonObject,
    ): Flow<ResultData<RootData>>

    suspend fun postCheckOut(
        token: String,
        request: OrderBodyRequest,
    ): Flow<ResultData<CheckOutResponse>>

    suspend fun getCheckoutComplete(
        token: String,
        checkoutId: String,
    ): Flow<ResultData<CheckOutCompleteResponse>>
}
