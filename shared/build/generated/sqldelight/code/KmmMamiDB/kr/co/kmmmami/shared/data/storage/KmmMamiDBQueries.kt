package kr.co.kmmmami.shared.`data`.storage

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Any
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Unit

public interface KmmMamiDBQueries : Transacter {
  public fun <T : Any> selectAll(mapper: (
    id: String,
    isBookmark: Boolean,
    dataType: String
  ) -> T): Query<T>

  public fun selectAll(): Query<BookmarkTable>

  public fun <T : Any> getBookMarkData(
    type: String,
    id: String,
    mapper: (
      id: String,
      isBookmark: Boolean,
      dataType: String
    ) -> T
  ): Query<T>

  public fun getBookMarkData(type: String, id: String): Query<BookmarkTable>

  public fun <T : Any> getBookMarkListData(type: String, mapper: (
    id: String,
    isBookmark: Boolean,
    dataType: String
  ) -> T): Query<T>

  public fun getBookMarkListData(type: String): Query<BookmarkTable>

  public fun <T : Any> getBookMarkDataSync(
    type: String,
    id: String,
    mapper: (
      id: String,
      isBookmark: Boolean,
      dataType: String
    ) -> T
  ): Query<T>

  public fun getBookMarkDataSync(type: String, id: String): Query<BookmarkTable>

  public fun <T : Any> getCategoryData(mapper: (
    primaryKey: Long,
    id: Long,
    name: String,
    nameEng: String,
    nameKor: String,
    imageUrl: String,
    depth: Long,
    orderData: Long,
    parentId: Long,
    productCount: Long,
    rootCategoryName: String
  ) -> T): Query<T>

  public fun getCategoryData(): Query<CategoryTable>

  public fun <T : Any> getCategoryDataSynchronous(mapper: (
    primaryKey: Long,
    id: Long,
    name: String,
    nameEng: String,
    nameKor: String,
    imageUrl: String,
    depth: Long,
    orderData: Long,
    parentId: Long,
    productCount: Long,
    rootCategoryName: String
  ) -> T): Query<T>

  public fun getCategoryDataSynchronous(): Query<CategoryTable>

  public fun <T : Any> getCategoryByRootCategoryName(rootCategoryName: String, mapper: (
    primaryKey: Long,
    id: Long,
    name: String,
    nameEng: String,
    nameKor: String,
    imageUrl: String,
    depth: Long,
    orderData: Long,
    parentId: Long,
    productCount: Long,
    rootCategoryName: String
  ) -> T): Query<T>

  public fun getCategoryByRootCategoryName(rootCategoryName: String): Query<CategoryTable>

  public fun <T : Any> getCategoryDataId(id: Long, mapper: (
    primaryKey: Long,
    id: Long,
    name: String,
    nameEng: String,
    nameKor: String,
    imageUrl: String,
    depth: Long,
    orderData: Long,
    parentId: Long,
    productCount: Long,
    rootCategoryName: String
  ) -> T): Query<T>

  public fun getCategoryDataId(id: Long): Query<CategoryTable>

  public fun getRootCategoryNameList(): Query<String>

  public fun getRootCategoryId(rootCategoryName: String): Query<Long>

  public fun <T : Any> getParentDataFromChild(parentId: Long, mapper: (
    primaryKey: Long,
    id: Long,
    name: String,
    nameEng: String,
    nameKor: String,
    imageUrl: String,
    depth: Long,
    orderData: Long,
    parentId: Long,
    productCount: Long,
    rootCategoryName: String
  ) -> T): Query<T>

  public fun getParentDataFromChild(parentId: Long): Query<CategoryTable>

  public fun <T : Any> getChildCategoryDataList(parentId: Long, mapper: (
    primaryKey: Long,
    id: Long,
    name: String,
    nameEng: String,
    nameKor: String,
    imageUrl: String,
    depth: Long,
    orderData: Long,
    parentId: Long,
    productCount: Long,
    rootCategoryName: String
  ) -> T): Query<T>

  public fun getChildCategoryDataList(parentId: Long): Query<CategoryTable>

  public fun <T : Any> getCategoryDataInRecentProduct(mapper: (
    _id: Long,
    id: String,
    name: String,
    sellerName: String,
    sellerId: String,
    thumbnailUrl: String,
    price: String,
    salePrice: String,
    salePercent: String,
    isSell: Boolean,
    isPurchased: Boolean,
    updateTime: Long
  ) -> T): Query<T>

  public fun getCategoryDataInRecentProduct(): Query<RecentProductTable>

  public fun <T : Any> getCategoryDataByOffsetInRecentProduct(
    limit: Long,
    offset: Long,
    mapper: (
      _id: Long,
      id: String,
      name: String,
      sellerName: String,
      sellerId: String,
      thumbnailUrl: String,
      price: String,
      salePrice: String,
      salePercent: String,
      isSell: Boolean,
      isPurchased: Boolean,
      updateTime: Long
    ) -> T
  ): Query<T>

  public fun getCategoryDataByOffsetInRecentProduct(limit: Long, offset: Long):
      Query<RecentProductTable>

  public fun <T : Any> getCategoryDataByIdInRecentProduct(id: String, mapper: (
    _id: Long,
    id: String,
    name: String,
    sellerName: String,
    sellerId: String,
    thumbnailUrl: String,
    price: String,
    salePrice: String,
    salePercent: String,
    isSell: Boolean,
    isPurchased: Boolean,
    updateTime: Long
  ) -> T): Query<T>

  public fun getCategoryDataByIdInRecentProduct(id: String): Query<RecentProductTable>

  public fun insert(
    id: String,
    isBookmark: Boolean,
    dataType: String
  ): Unit

  public fun insertBookmarkObject(BookmarkTable: BookmarkTable): Unit

  public fun updateBookmark(
    id: String,
    isBookmark: Boolean,
    dataType: String,
    id_: String
  ): Unit

  public fun removeAllBookmark(): Unit

  public fun insertCategoryData(
    id: Long,
    name: String,
    nameEng: String,
    nameKor: String,
    imageUrl: String,
    depth: Long,
    orderData: Long,
    parentId: Long,
    productCount: Long,
    rootCategoryName: String
  ): Unit

  public fun deleteCategoryData(): Unit

  public fun insertProductData(RecentProductTable: RecentProductTable): Unit

  public fun updateProductData(RecentProductTable: RecentProductTable): Unit

  public fun deleteProductDataInRecentProduct(id: String): Unit

  public fun deleteProductDataAllInRecentProduct(): Unit

  public fun upserBookmark(
    isBookmark: Boolean,
    dataType: String,
    id: String
  ): Unit

  public fun deleteBookMarkData(type: String): Unit
}
