package kr.co.kmmmami.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.add
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.putJsonArray
import kr.co.kmmmami.core_data.base.safeApiCallFlow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.core_data.model.RootData
import kr.co.kmmmami.data.networking.api.MarketApi
import kr.co.kmmmami.data.utils.QueryMapKey.BENEFITS
import kr.co.kmmmami.data.utils.QueryMapKey.CATEGORY_GROUP_ID
import kr.co.kmmmami.data.utils.QueryMapKey.DEVICE_TYPE
import kr.co.kmmmami.data.utils.QueryMapKey.EMBED
import kr.co.kmmmami.data.utils.QueryMapKey.FILTERS
import kr.co.kmmmami.data.utils.QueryMapKey.LT
import kr.co.kmmmami.data.utils.QueryMapKey.NEW_FILTER
import kr.co.kmmmami.data.utils.QueryMapKey.ORDER
import kr.co.kmmmami.data.utils.QueryMapKey.PRODUCT_ID
import kr.co.kmmmami.data.utils.QueryMapKey.QTY
import kr.co.kmmmami.data.utils.QueryMapKey.RESULT_TYPE
import kr.co.kmmmami.data.utils.QueryMapKey.RES_TYPE
import kr.co.kmmmami.data.utils.QueryMapKey.STORE_TYPE
import kr.co.kmmmami.data.utils.QueryMapKey.TAB_TYPE
import kr.co.kmmmami.data.utils.QueryMapKey.TOTAL_COUNT
import kr.co.kmmmami.data.utils.QueryMapKey.TYPE
import kr.co.kmmmami.data.utils.QueryMapKey.VERSION
import kr.co.kmmmami.data.utils.QueryMapUtils.getPagingQueryMap
import kr.co.kmmmami.data.utils.QueryMapUtils.getQueryMapOnlyLimit
import kr.co.kmmmami.domain.model.request.OrderBodyRequest
import kr.co.kmmmami.domain.model.response.*
import kr.co.kmmmami.domain.repository.MarketRepository

class MarketRepositoryImpl(private val marketAPI: MarketApi) : MarketRepository {

    override suspend fun getMainFashion(token: String): Flow<ResultData<MainListResponse>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                this[TAB_TYPE] = "fashion"
                this[VERSION] = "204"
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getProductsByAll(token, queryMap)
                }
            )
        }
    }

    override suspend fun getMainBaby(token: String): Flow<ResultData<MainListResponse>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                this[TAB_TYPE] = "baby"
                this[VERSION] = "204"
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getProductsByAll(token, queryMap)
                }
            )
        }
    }

    override suspend fun getMainLife(token: String): Flow<ResultData<MainListResponse>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                this[TAB_TYPE] = "life"
                this[VERSION] = "204"
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getProductsByAll(token, queryMap)
                }
            )
        }
    }

    override suspend fun getMainInfant(token: String): Flow<ResultData<MainListResponse>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                this[TAB_TYPE] = "infant"
                this[VERSION] = "204"
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getProductsByAll(token, queryMap)
                }
            )
        }
    }

    override suspend fun getMainMaternity(token: String): Flow<ResultData<MainListResponse>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                this[TAB_TYPE] = "maternity"
                this[VERSION] = "204"
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getProductsByAll(token, queryMap)
                }
            )
        }
    }

    override suspend fun getCategoryProductList(
        token: String,
        categoryId: String,
        offset: Int,
        isSale: Boolean,
        order: String,
        priceFilterMap: HashMap<String, String>?,
        saleFilterMap: HashMap<String, String>?,
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(offset = offset).apply {
                if (isSale) {
                    this[BENEFITS] = "sale"
                }
                if (order.isNotEmpty()) {
                    this[ORDER] = order
                }
                if (priceFilterMap != null) {
                    this.putAll(priceFilterMap)
                }
                if (saleFilterMap != null) {
                    this.putAll(saleFilterMap)
                }
                this[TYPE] = "all"
            }
            emit(
                safeApiCallFlow {
                    marketAPI.getCategoryProductList(token, categoryId, queryMap)
                }
            )
        }
    }

    override suspend fun getFashionAllProductList(
        token: String,
        offset: Int,
        isSale: Boolean,
        order: String,
        priceFilterMap: HashMap<String, String>?,
        saleFilterMap: HashMap<String, String>?,
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(offset = offset).apply {
                if (isSale) {
                    this[BENEFITS] = "sale"
                }
                if (order.isNotEmpty()) {
                    this[ORDER] = order
                }
                if (priceFilterMap != null) {
                    this.putAll(priceFilterMap)
                }
                if (saleFilterMap != null) {
                    this.putAll(saleFilterMap)
                }
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getFashionProductsByAll(token, queryMap)
                }
            )
        }
    }

    override suspend fun getBabyAllProductList(
        token: String,
        offset: Int,
        isSale: Boolean,
        order: String,
        priceFilterMap: HashMap<String, String>?,
        saleFilterMap: HashMap<String, String>?,
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(offset = offset).apply {
                if (isSale) {
                    this[BENEFITS] = "sale"
                }
                if (order.isNotEmpty()) {
                    this[ORDER] = order
                }
                if (priceFilterMap != null) {
                    this.putAll(priceFilterMap)
                }
                if (saleFilterMap != null) {
                    this.putAll(saleFilterMap)
                }
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getBabyProductsByAll(token, queryMap)
                }
            )
        }
    }

    override suspend fun getLifeAllProductList(
        token: String,
        offset: Int,
        isSale: Boolean,
        order: String,
        priceFilterMap: HashMap<String, String>?,
        saleFilterMap: HashMap<String, String>?,
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(offset = offset).apply {
                if (isSale) {
                    this[BENEFITS] = "sale"
                }
                if (order.isNotEmpty()) {
                    this[ORDER] = order
                }
                if (priceFilterMap != null) {
                    this.putAll(priceFilterMap)
                }
                if (saleFilterMap != null) {
                    this.putAll(saleFilterMap)
                }
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getLifeProductsByAll(token, queryMap)
                }
            )
        }
    }

    override suspend fun getInfantAllProductList(
        token: String,
        offset: Int,
        isSale: Boolean,
        order: String,
        priceFilterMap: HashMap<String, String>?,
        saleFilterMap: HashMap<String, String>?,
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(offset = offset).apply {
                if (isSale) {
                    this[BENEFITS] = "sale"
                }
                if (order.isNotEmpty()) {
                    this[ORDER] = order
                }
                if (priceFilterMap != null) {
                    this.putAll(priceFilterMap)
                }
                if (saleFilterMap != null) {
                    this.putAll(saleFilterMap)
                }
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getInfantProductsByAll(token, queryMap)
                }
            )
        }
    }

    override suspend fun getMaternityAllProductList(
        token: String,
        offset: Int,
        isSale: Boolean,
        order: String,
        priceFilterMap: HashMap<String, String>?,
        saleFilterMap: HashMap<String, String>?,
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(offset = offset).apply {
                if (isSale) {
                    this[BENEFITS] = "sale"
                }
                if (order.isNotEmpty()) {
                    this[ORDER] = order
                }
                if (priceFilterMap != null) {
                    this.putAll(priceFilterMap)
                }
                if (saleFilterMap != null) {
                    this.putAll(saleFilterMap)
                }
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getMaternityProductsByAll(token, queryMap)
                }
            )
        }
    }

    override suspend fun getMyBanners(
        token: String,
    ): Flow<ResultData<MyBannersResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    marketAPI.getMyBanners(token)
                }
            )
        }
    }

    override suspend fun getAlarms(
        token: String,
        lt: String,
    ): Flow<ResultData<MyAlarmListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap()
            if (lt.isNotEmpty()) queryMap[LT] = lt

            emit(
                safeApiCallFlow {
                    marketAPI.getAlarms(token, queryMap)
                }
            )
        }
    }

    override suspend fun postAlarmsDefault(token: String): Flow<ResultData<MyAlarmListResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    marketAPI.postAlarmsDefault(token, getQueryMapOnlyLimit())
                }
            )
        }
    }

    override suspend fun getProductInfo(
        token: String,
        productId: String,
    ): Flow<ResultData<ProductItemSection1Response>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                this[RES_TYPE] = "section1"
                this[VERSION] = "2102"
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getProductInfo(token, productId, queryMap)
                }
            )
        }
    }

    override suspend fun getProductsInquiriesWithCount(
        token: String,
        productId: String,
        isOnlyMyQa: Boolean,
    ): Flow<ResultData<QnaListWithTotalCountResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(limit = 3).apply {
                this[TYPE] = if (isOnlyMyQa) "self" else "all"
                this[TOTAL_COUNT] = "true"
                this[RESULT_TYPE] = "content"
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getProductsInquiriesWithCount(token, productId, queryMap)
                }
            )
        }
    }

    override suspend fun postProductsInquiries(
        token: String,
        productId: String,
        jsonObject: JsonObject,
    ): Flow<ResultData<RootData>> {
        return flow {
            emit(
                safeApiCallFlow {
                    marketAPI.postProductsInquiries(token, productId, jsonObject)
                }
            )
        }
    }

    override suspend fun getProductSection2Info(
        token: String,
        productId: String,
    ): Flow<ResultData<ProductItemSection2Response>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                this[RES_TYPE] = "section2"
                this[VERSION] = "2102"
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getProductInfo(token, productId, queryMap)
                }
            )
        }
    }

    override suspend fun postProductsBookmark(
        token: String,
        id: String,
    ): Flow<ResultData<BookMarkResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    marketAPI.postProductsBookmark(token, id)
                }
            )
        }
    }

    override suspend fun deleteProductsBookmark(
        token: String,
        id: String,
    ): Flow<ResultData<BookMarkResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    marketAPI.deleteProductsBookmark(token, id)
                }
            )
        }
    }

    override suspend fun getUserSelfProductsByCategoryGroups(
        token: String,
        offset: Int,
        categoryGroupId: String,
        isSoldOut: Boolean,
        orderFilter: String,
    ): Flow<ResultData<ProductBookMarkListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(offset = offset).apply {
                if (offset == 0) this[EMBED] = "category-groups"
                if (isSoldOut) this[FILTERS] = "in-stock"
                if (categoryGroupId.isNotEmpty()) this[CATEGORY_GROUP_ID] = categoryGroupId
                if (orderFilter.isNotEmpty()) this[ORDER] = orderFilter
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getUserSelfProducts(token, queryMap)
                }
            )
        }
    }

    override suspend fun getUserSelfProducts(
        token: String,
        offset: Int,
        categoryGroupId: String,
        isSoldOut: Boolean,
        orderFilter: String,
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(offset = offset).apply {
                if (offset == 0) this[EMBED] = "category-groups"
                if (isSoldOut) this[FILTERS] = "in-stock"
                if (categoryGroupId.isNotEmpty()) this[CATEGORY_GROUP_ID] = categoryGroupId
                if (orderFilter.isNotEmpty()) this[ORDER] = orderFilter
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getUserSelfProducts(token, queryMap)
                }
            )
        }
    }

    override suspend fun getUserSelfSellers(
        token: String,
        offset: Int,
    ): Flow<ResultData<SellerListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(offset = offset).apply {
                this[NEW_FILTER] = "true"
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getUserSelfSellers(token, queryMap)
                }
            )
        }
    }

    override suspend fun deleteStoreBookmark(
        token: String,
        sellerId: String,
    ): Flow<ResultData<RootData>> {
        return flow {
            emit(
                safeApiCallFlow {
                    marketAPI.deleteStoreBookmark(token, sellerId)
                }
            )
        }
    }

    override suspend fun postStoreBookmark(
        token: String,
        sellerId: String,
    ): Flow<ResultData<RootData>> {
        return flow {
            emit(
                safeApiCallFlow {
                    marketAPI.postStoreBookmark(token, sellerId)
                }
            )
        }
    }

    override suspend fun postStoreBookmarkList(
        token: String,
        sellers: List<String>,
    ): Flow<ResultData<StoreBookMarkResponse>> {
        return flow {
            val jsonObject = buildJsonObject {
                putJsonArray("mdNos") {
                    sellers.forEach {
                        add(it)
                    }
                }
            }

            emit(
                safeApiCallFlow {
                    marketAPI.postStoreBookmarkList(token, jsonObject)
                }
            )
        }
    }

    override suspend fun postCouponDownload(
        token: String,
        jsonObject: JsonObject,
    ): Flow<ResultData<CouponDownloadResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    marketAPI.postCouponDownload(token, jsonObject)
                }
            )
        }
    }

    override suspend fun getTagsProduct(
        token: String,
        id: String,
        lastItemId: String,
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            val queryMap = getQueryMapOnlyLimit().apply {
                if (!lastItemId.isNullOrEmpty()) {
                    this[LT] = lastItemId
                }
            }
            emit(
                safeApiCallFlow {
                    marketAPI.getTagsProduct(token, id, queryMap)
                }
            )
        }
    }

    override suspend fun getTagsProductByName(
        token: String,
        tagName: String,
        lastItemId: String,
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            val queryMap = getQueryMapOnlyLimit().apply {
                if (!lastItemId.isNullOrEmpty()) {
                    this[LT] = lastItemId
                }
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getTagsProductByName(token, tagName, queryMap)
                }
            )
        }
    }

    override suspend fun getSellersMain(
        token: String,
        offset: Int,
        tabPosition: String,
        orderFilter: String,
    ): Flow<ResultData<SellerListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(offset = offset).apply {
                this[STORE_TYPE] = tabPosition
                if (orderFilter.isNotEmpty()) this[ORDER] = orderFilter
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getSellersMain(token, queryMap)
                }
            )
        }
    }

    override suspend fun getOrdersTemporary(
        token: String,
        orderType: String,
        productId: String,
        productQty: String,
    ): Flow<ResultData<OrderTemporaryResponse>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                this[TYPE] = orderType
                this[PRODUCT_ID] = productId
                this[DEVICE_TYPE] = "android"
                this[VERSION] = "2102"
                this[QTY] = productQty
            }

            emit(
                safeApiCallFlow {
                    marketAPI.getOrdersTemporary(token, queryMap)
                }
            )
        }
    }

    override suspend fun postDeliveryAddresses(
        token: String,
        jsonObject: JsonObject,
    ): Flow<ResultData<DeliveryAddressListResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    marketAPI.postDeliveryAddresses(token, jsonObject)
                }
            )
        }
    }

    override suspend fun putDeliveryAddresses(
        token: String,
        addressId: String,
        jsonObject: JsonObject,
    ): Flow<ResultData<DeliveryAddressResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    marketAPI.putDeliveryAddresses(token, addressId, jsonObject)
                }
            )
        }
    }

    override suspend fun getDeliveryAddresses(
        token: String,
        map: HashMap<String, String>,
    ): Flow<ResultData<DeliveryAddressListResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    marketAPI.getDeliveryAddress(token, map)
                }
            )
        }
    }

    override suspend fun deleteDeliveryAddresses(
        token: String,
        addressId: String,
    ): Flow<ResultData<RootData>> {
        return flow {
            emit(
                safeApiCallFlow {
                    marketAPI.deleteDeliveryAddresses(token, addressId)
                }
            )
        }
    }

    override suspend fun postDeliveryAddressesIdRequestInfo(
        token: String,
        addressId: String,
        jsonObject: JsonObject,
    ): Flow<ResultData<RootData>> {
        return flow {
            emit(
                safeApiCallFlow {
                    marketAPI.postDeliveryAddressesIdRequestInfo(token, addressId, jsonObject)
                }
            )
        }
    }

    override suspend fun postCheckOut(
        token: String,
        request: OrderBodyRequest,
    ): Flow<ResultData<CheckOutResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    marketAPI.postCheckout(token, request)
                }
            )
        }
    }

    override suspend fun getCheckoutComplete(
        token: String,
        checkoutId: String,
    ): Flow<ResultData<CheckOutCompleteResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    marketAPI.getCheckoutComplete(token, checkoutId)
                }
            )
        }
    }
}
