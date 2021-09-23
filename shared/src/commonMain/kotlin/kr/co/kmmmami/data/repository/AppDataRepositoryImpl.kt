package kr.co.kmmmami.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.InternalSerializationApi
import kr.co.kmmmami.core_data.FindErrorCode
import kr.co.kmmmami.core_data.base.safeApiCallFlow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.data.local.storage.Database
import kr.co.kmmmami.data.networking.api.LoginAPI
import kr.co.kmmmami.data.networking.api.LoginCommerceAPI
import kr.co.kmmmami.domain.model.BOOKMARK_DATA_TYPE
import kr.co.kmmmami.domain.model.BookmarkData
import kr.co.kmmmami.domain.model.response.*
import kr.co.kmmmami.domain.repository.AppDataRepository
import kr.co.kmmmami.shared.data.storage.BookmarkTable

@OptIn(InternalSerializationApi::class)
class AppDataRepositoryImpl(
    private val loginAPI: LoginAPI,
    private val loginCommerceAPI: LoginCommerceAPI,
    private val appDatabase: Database
) : AppDataRepository {
    override suspend fun getVersion(
        token: String,
    ): Flow<ResultData<VersionResponse>> {
        return flow {
            emit(safeApiCallFlow {
                loginAPI.getVersions(token)
            })
        }
    }

    override suspend fun getUrls(
        token: String,
    ): Flow<ResultData<UrlsResponse>> {
        return flow {
            emit(safeApiCallFlow {
                loginAPI.getUrls(token)
            })
        }
    }

    override suspend fun getImages(
        token: String,
    ): Flow<ResultData<ImagesResponse>> {
        return flow {

            emit(safeApiCallFlow {
                loginCommerceAPI.getImages(token)
            })
        }
    }

    override suspend fun getCategories(
        token: String,
    ): Flow<ResultData<CategoryResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginCommerceAPI.getCategories(
                        token
                    )
                }
            )
        }
    }

    override suspend fun getTexts(
        token: String,
    ): Flow<ResultData<TextsResponse>> {
        return flow {
            emit(safeApiCallFlow {
                loginAPI.getTexts(token)
            })
        }
    }

    override fun getCategoryData(): List<CategoryData> {
        return appDatabase.dbQuery.getCategoryData().executeAsList().map {
            CategoryData(
                id = it.id.toInt(),
                name = it.name,
                nameEng = it.nameEng,
                nameKor = it.nameKor,
                imageUrl = it.imageUrl,
                depth = it.depth.toInt(),
                order = 0,
                parentId = it.parentId.toInt(),
                productCount = it.productCount.toInt(),
                rootCategoryName = it.rootCategoryName
            )
        }
    }

    override fun getCategoryDataSynchronous(): List<CategoryData> {
        return appDatabase.dbQuery.getCategoryDataSynchronous().executeAsList().map {
            CategoryData(
                id = it.id.toInt(),
                name = it.name,
                nameEng = it.nameEng,
                nameKor = it.nameKor,
                imageUrl = it.imageUrl,
                depth = it.depth.toInt(),
                order = 0,
                parentId = it.parentId.toInt(),
                productCount = it.productCount.toInt(),
                rootCategoryName = it.rootCategoryName
            )
        }
    }

    override fun getRootCategoryNameList(): List<String> {
        return appDatabase.dbQuery.getRootCategoryNameList().executeAsList()
    }

    override fun getRootCategoryIdList(): List<Int> {
        val rootCategoryNameList = appDatabase.dbQuery.getRootCategoryNameList().executeAsList()

        val rootCategoryIdList = mutableListOf<Int>()
        rootCategoryNameList.forEach { rootCategoryName ->
            rootCategoryIdList.add(appDatabase.dbQuery.getRootCategoryId(rootCategoryName).executeAsOne().toInt())
        }

        return rootCategoryIdList
    }

    override fun getCategoryByRootCategoryName(rootCategoryName: String): List<CategoryData> {
        return appDatabase.dbQuery.getCategoryByRootCategoryName(rootCategoryName).executeAsList().map {
            CategoryData(
                id = it.id.toInt(),
                name = it.name,
                nameEng = it.nameEng,
                nameKor = it.nameKor,
                imageUrl = it.imageUrl,
                depth = it.depth.toInt(),
                order = 0,
                parentId = it.parentId.toInt(),
                productCount = it.productCount.toInt(),
                rootCategoryName = it.rootCategoryName
            )
        }
    }

    override fun getCategoryDataForId(id: Int): List<CategoryData> {
        return appDatabase.dbQuery.getCategoryDataId(id.toLong()).executeAsList().map {
            CategoryData(
                id = it.id.toInt(),
                name = it.name,
                nameEng = it.nameEng,
                nameKor = it.nameKor,
                imageUrl = it.imageUrl,
                depth = it.depth.toInt(),
                order = 0,
                parentId = it.parentId.toInt(),
                productCount = it.productCount.toInt(),
                rootCategoryName = it.rootCategoryName
            )
        }
    }

    override fun getChildCategoryDataList(parentId: Int): List<CategoryData> {
        return appDatabase.dbQuery.getChildCategoryDataList(parentId.toLong()).executeAsList().map {
            CategoryData(
                id = it.id.toInt(),
                name = it.name,
                nameEng = it.nameEng,
                nameKor = it.nameKor,
                imageUrl = it.imageUrl,
                depth = it.depth.toInt(),
                order = it.orderData.toInt(),
                parentId = it.parentId.toInt(),
                productCount = it.productCount.toInt(),
                rootCategoryName = it.rootCategoryName
            )
        }
    }

    override fun insertCategoryData(categoryList: List<CategoryData>) {
        appDatabase.dbQuery.transaction {
            categoryList.forEach {
                appDatabase.dbQuery.insertCategoryData(
                    it.id.toLong(),
                    it.name,
                    it.nameEng,
                    it.nameKor,
                    it.imageUrl ?: "",
                    it.depth.toLong(),
                    it.order.toLong(),
                    it.parentId?.toLong() ?: 0,
                    it.productCount.toLong(),
                    it.rootCategoryName
                )
            }
        }
    }

    override fun deleteCategoryData() {
        appDatabase.dbQuery.deleteCategoryData()
    }

    override fun deleteAllInsertCategoryData(categoryList: List<CategoryData>): ResultData<Unit> {
        return try {
            appDatabase.dbQuery.transaction {
                appDatabase.dbQuery.deleteCategoryData()
                categoryList.forEach {
                    appDatabase.dbQuery.insertCategoryData(
                        it.id.toLong(),
                        it.name,
                        it.nameEng,
                        it.nameKor,
                        it.imageUrl ?: "",
                        it.depth.toLong(),
                        it.order.toLong(),
                        it.parentId?.toLong() ?: 0,
                        it.productCount.toLong(),
                        it.rootCategoryName
                    )
                }
            }
            ResultData.Success(Unit)
        } catch (e: Exception) {
//            Logger.e(e, "${e.message}")
            val message: String = FindErrorCode.getErrorResponse(0)
            ResultData.Error(message = message, exception = e as? Exception)
        }
    }

    override fun isRootCategoryEmpty(): Boolean {
        val rootCategoryNameList = appDatabase.dbQuery.getRootCategoryNameList().executeAsList()
        return if (rootCategoryNameList.isEmpty()) {
            true
        } else {
            rootCategoryNameList.count { it.isEmpty() } > 0
        }
    }

    override fun insertRecentProductData(product: ProductData) {
//        val preProduct = appDatabase.recentProductDao().getCategoryDataId(product.id)
//        // update
//        if (preProduct != null) {
//            val recentProductEntity = product.asDatabaseModel()
//            recentProductEntity._id = preProduct._id
//            appDatabase.recentProductDao().updateProductData(recentProductEntity)
//        } else {
//            // insert
//            appDatabase.recentProductDao().insertProductData(product.asDatabaseModel())
//        }
//        val data = appDatabase.recentProductDao().getCategoryData()
//        if (data.size == 101) {
//            deleteProductData(data.last().id)
//        }
    }

    override fun insertRecentProductData(product: ProductItemSection1Data) {
//        val preProduct = appDatabase.recentProductDao().getCategoryDataId(product.id)
//        // update
//        if (preProduct != null) {
//            val recentProductEntity = product.asDatabaseModel()
//            recentProductEntity._id = preProduct._id
//            appDatabase.recentProductDao().updateProductData(recentProductEntity)
//        } else {
//            // insert
//            appDatabase.recentProductDao().insertProductData(product.asDatabaseModel())
//        }
//        val data = appDatabase.recentProductDao().getCategoryData()
//        if (data.size == 101) {
//            deleteProductData(data.last().id)
//        }
    }

    override fun getRecentProductData(): Flow<List<ProductData>> {
        return flow {
//            emit(appDatabase.recentProductDao().getCategoryData().asDomainModel())
        }
    }

    override fun getRecentProductData(offset: Int, limit: Int): Flow<List<ProductData>> {
        return flow {
//            emit(appDatabase.recentProductDao().getCategoryData(offset, limit).asDomainModel())
        }
    }

    override fun deleteProductData(id: String) {
//        appDatabase.recentProductDao().deleteProductData(id)
    }

    override fun addBookMarkList(type: BOOKMARK_DATA_TYPE, data: List<String>) {
        val entities = data.map { id ->
            BookmarkTable(
                id = id,
                isBookmark = true,
                dataType = type.toString(),
            )
        }
        appDatabase.dbQuery.transaction {
            appDatabase.dbQuery.deleteBookMarkData(type.toString())
            entities.forEach { data ->
                appDatabase.dbQuery.insertBookmarkObject(data)
            }
        }
    }

    override fun getIsBookMark(id: String, type: BOOKMARK_DATA_TYPE): Boolean {
        return try {
            appDatabase.dbQuery.getBookMarkData(type.toString(), id).executeAsOneOrNull()?.isBookmark ?: false
        } catch (e: Exception) {
            // kotlinx.coroutines.JobCancellationException: Job was cancelled
            false
        }
    }

    override fun insertBookMarkData(data: BookmarkData) {
        appDatabase.dbQuery.transaction {
            appDatabase.dbQuery.insertBookmarkObject(BookmarkTable(data.id, data.isBookmark, data.dataType.toString()))
        }
    }

    override fun insertBookMarkDataList(dataList: List<BookmarkData>) {
        appDatabase.dbQuery.transaction {
            dataList.forEach { data ->
                appDatabase.dbQuery.insertBookmarkObject(BookmarkTable(data.id, data.isBookmark, data.dataType.toString()))
            }
        }
    }

    override fun clearAllTables() {
        appDatabase.dbQuery.transaction {
            appDatabase.dbQuery.removeAllBookmark()
            appDatabase.dbQuery.deleteCategoryData()
        }
    }

    override fun getIsBookMarkSync(id: String, type: BOOKMARK_DATA_TYPE): Boolean {
        return try {
            appDatabase.dbQuery.getBookMarkDataSync(type.toString(), id).executeAsOneOrNull()?.isBookmark ?: false
        } catch (e: Exception) {
            // kotlinx.coroutines.JobCancellationException: Job was cancelled
            false
        }
    }
//    override fun insertProductDetailDataByList(data: ProductItemSection1Data) {
//        GlobalScope.launch {
//            productDetailDbSource.insertProductDetailDataByList(data)
//        }
//    }
//
//    override suspend fun expiredProductDetailData() {
//        appDatabase.productDetailDao().expiredProductDetailData()
//    }
}
