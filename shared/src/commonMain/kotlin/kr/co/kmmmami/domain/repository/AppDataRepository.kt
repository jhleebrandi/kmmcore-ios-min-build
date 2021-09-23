package kr.co.kmmmami.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.domain.model.BOOKMARK_DATA_TYPE
import kr.co.kmmmami.domain.model.BookmarkData
import kr.co.kmmmami.domain.model.response.*

interface AppDataRepository {
    suspend fun getVersion(
        token: String,
    ): Flow<ResultData<VersionResponse>>

    suspend fun getUrls(
        token: String,
    ): Flow<ResultData<UrlsResponse>>

    suspend fun getImages(
        token: String,
    ): Flow<ResultData<ImagesResponse>>

    suspend fun getCategories(
        token: String,
    ): Flow<ResultData<CategoryResponse>>

    suspend fun getTexts(
        token: String,
    ): Flow<ResultData<TextsResponse>>

    fun getCategoryData(): List<CategoryData>

    fun getCategoryDataSynchronous(): List<CategoryData>

    fun getRootCategoryNameList(): List<String>

    fun getRootCategoryIdList(): List<Int>

    fun getCategoryByRootCategoryName(rootCategoryName: String): List<CategoryData>

    fun getCategoryDataForId(id: Int): List<CategoryData>

    fun getChildCategoryDataList(parentId: Int): List<CategoryData>

    fun insertCategoryData(categoryList: List<CategoryData>)

    fun deleteCategoryData()

    fun deleteAllInsertCategoryData(categoryList: List<CategoryData>): ResultData<Unit>

    fun isRootCategoryEmpty(): Boolean

    fun insertRecentProductData(product: ProductData)

    fun insertRecentProductData(product: ProductItemSection1Data)

    fun getRecentProductData(): Flow<List<ProductData>>

    fun getRecentProductData(offset: Int, limit: Int): Flow<List<ProductData>>

    fun deleteProductData(id: String)

    fun addBookMarkList(type: BOOKMARK_DATA_TYPE, data: List<String>)

    fun getIsBookMark(id: String, type: BOOKMARK_DATA_TYPE): Boolean

    fun insertBookMarkData(data: BookmarkData)

    fun insertBookMarkDataList(dataList: List<BookmarkData>)

    fun clearAllTables()

    fun getIsBookMarkSync(id: String, type: BOOKMARK_DATA_TYPE): Boolean
//
//    fun insertProductDetailDataByList(data: ProductItemSection1Data)
//
//    suspend fun expiredProductDetailData()
}
