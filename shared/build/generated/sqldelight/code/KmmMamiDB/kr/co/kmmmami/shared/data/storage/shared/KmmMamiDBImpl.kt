package kr.co.kmmmami.shared.`data`.storage.shared

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.TransacterImpl
import com.squareup.sqldelight.`internal`.copyOnWriteList
import com.squareup.sqldelight.db.SqlCursor
import com.squareup.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.MutableList
import kotlin.reflect.KClass
import kr.co.kmmmami.shared.`data`.storage.BookmarkTable
import kr.co.kmmmami.shared.`data`.storage.CategoryTable
import kr.co.kmmmami.shared.`data`.storage.KmmMamiDB
import kr.co.kmmmami.shared.`data`.storage.KmmMamiDBQueries
import kr.co.kmmmami.shared.`data`.storage.RecentProductTable

internal val KClass<KmmMamiDB>.schema: SqlDriver.Schema
  get() = KmmMamiDBImpl.Schema

internal fun KClass<KmmMamiDB>.newInstance(driver: SqlDriver): KmmMamiDB = KmmMamiDBImpl(driver)

private class KmmMamiDBImpl(
  driver: SqlDriver
) : TransacterImpl(driver), KmmMamiDB {
  public override val kmmMamiDBQueries: KmmMamiDBQueriesImpl = KmmMamiDBQueriesImpl(this, driver)

  public object Schema : SqlDriver.Schema {
    public override val version: Int
      get() = 2

    public override fun create(driver: SqlDriver): Unit {
      driver.execute(null, """
          |CREATE TABLE BookmarkTable (
          |  id TEXT NOT NULL PRIMARY KEY,
          |  isBookmark INTEGER DEFAULT 0 NOT NULL,
          |  dataType TEXT NOT NULL
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE CategoryTable (
          |  primaryKey INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
          |  id INTEGER NOT NULL,
          |  name TEXT NOT NULL,
          |  nameEng TEXT NOT NULL,
          |  nameKor TEXT NOT NULL,
          |  imageUrl TEXT NOT NULL,
          |  depth INTEGER NOT NULL,
          |  orderData INTEGER NOT NULL,
          |  parentId INTEGER NOT NULL,
          |  productCount INTEGER NOT NULL,
          |  rootCategoryName TEXT NOT NULL
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE RecentProductTable (
          |  _id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
          |  id TEXT NOT NULL,
          |  name TEXT NOT NULL,
          |  sellerName TEXT NOT NULL,
          |  sellerId TEXT NOT NULL,
          |  thumbnailUrl TEXT NOT NULL,
          |  price TEXT NOT NULL,
          |  salePrice TEXT NOT NULL,
          |  salePercent TEXT NOT NULL,
          |  isSell INTEGER DEFAULT 0 NOT NULL,
          |  isPurchased INTEGER DEFAULT 0 NOT NULL,
          |  updateTime INTEGER NOT NULL
          |)
          """.trimMargin(), 0)
    }

    public override fun migrate(
      driver: SqlDriver,
      oldVersion: Int,
      newVersion: Int
    ): Unit {
      if (oldVersion <= 1 && newVersion > 1) {
        driver.execute(null, "ALTER TABLE RecentProductTable ADD COLUMN tempTxt TEXT", 0)
      }
    }
  }
}

private class KmmMamiDBQueriesImpl(
  private val database: KmmMamiDBImpl,
  private val driver: SqlDriver
) : TransacterImpl(driver), KmmMamiDBQueries {
  internal val selectAll: MutableList<Query<*>> = copyOnWriteList()

  internal val getBookMarkData: MutableList<Query<*>> = copyOnWriteList()

  internal val getBookMarkListData: MutableList<Query<*>> = copyOnWriteList()

  internal val getBookMarkDataSync: MutableList<Query<*>> = copyOnWriteList()

  internal val getCategoryData: MutableList<Query<*>> = copyOnWriteList()

  internal val getCategoryDataSynchronous: MutableList<Query<*>> = copyOnWriteList()

  internal val getCategoryByRootCategoryName: MutableList<Query<*>> = copyOnWriteList()

  internal val getCategoryDataId: MutableList<Query<*>> = copyOnWriteList()

  internal val getRootCategoryNameList: MutableList<Query<*>> = copyOnWriteList()

  internal val getRootCategoryId: MutableList<Query<*>> = copyOnWriteList()

  internal val getParentDataFromChild: MutableList<Query<*>> = copyOnWriteList()

  internal val getChildCategoryDataList: MutableList<Query<*>> = copyOnWriteList()

  internal val getCategoryDataInRecentProduct: MutableList<Query<*>> = copyOnWriteList()

  internal val getCategoryDataByOffsetInRecentProduct: MutableList<Query<*>> = copyOnWriteList()

  internal val getCategoryDataByIdInRecentProduct: MutableList<Query<*>> = copyOnWriteList()

  public override fun <T : Any> selectAll(mapper: (
    id: String,
    isBookmark: Boolean,
    dataType: String
  ) -> T): Query<T> = Query(1486285798, selectAll, driver, "KmmMamiDB.sq", "selectAll", """
  |SELECT *
  |FROM BookmarkTable
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!! == 1L,
      cursor.getString(2)!!
    )
  }

  public override fun selectAll(): Query<BookmarkTable> = selectAll { id, isBookmark, dataType ->
    BookmarkTable(
      id,
      isBookmark,
      dataType
    )
  }

  public override fun <T : Any> getBookMarkData(
    type: String,
    id: String,
    mapper: (
      id: String,
      isBookmark: Boolean,
      dataType: String
    ) -> T
  ): Query<T> = GetBookMarkDataQuery(type, id) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!! == 1L,
      cursor.getString(2)!!
    )
  }

  public override fun getBookMarkData(type: String, id: String): Query<BookmarkTable> =
      getBookMarkData(type, id) { id_, isBookmark, dataType ->
    BookmarkTable(
      id_,
      isBookmark,
      dataType
    )
  }

  public override fun <T : Any> getBookMarkListData(type: String, mapper: (
    id: String,
    isBookmark: Boolean,
    dataType: String
  ) -> T): Query<T> = GetBookMarkListDataQuery(type) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!! == 1L,
      cursor.getString(2)!!
    )
  }

  public override fun getBookMarkListData(type: String): Query<BookmarkTable> =
      getBookMarkListData(type) { id, isBookmark, dataType ->
    BookmarkTable(
      id,
      isBookmark,
      dataType
    )
  }

  public override fun <T : Any> getBookMarkDataSync(
    type: String,
    id: String,
    mapper: (
      id: String,
      isBookmark: Boolean,
      dataType: String
    ) -> T
  ): Query<T> = GetBookMarkDataSyncQuery(type, id) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!! == 1L,
      cursor.getString(2)!!
    )
  }

  public override fun getBookMarkDataSync(type: String, id: String): Query<BookmarkTable> =
      getBookMarkDataSync(type, id) { id_, isBookmark, dataType ->
    BookmarkTable(
      id_,
      isBookmark,
      dataType
    )
  }

  public override fun <T : Any> getCategoryData(mapper: (
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
  ) -> T): Query<T> = Query(939534431, getCategoryData, driver, "KmmMamiDB.sq", "getCategoryData",
      "SELECT * FROM CategoryTable") { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getString(5)!!,
      cursor.getLong(6)!!,
      cursor.getLong(7)!!,
      cursor.getLong(8)!!,
      cursor.getLong(9)!!,
      cursor.getString(10)!!
    )
  }

  public override fun getCategoryData(): Query<CategoryTable> = getCategoryData { primaryKey, id,
      name, nameEng, nameKor, imageUrl, depth, orderData, parentId, productCount,
      rootCategoryName ->
    CategoryTable(
      primaryKey,
      id,
      name,
      nameEng,
      nameKor,
      imageUrl,
      depth,
      orderData,
      parentId,
      productCount,
      rootCategoryName
    )
  }

  public override fun <T : Any> getCategoryDataSynchronous(mapper: (
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
  ) -> T): Query<T> = Query(1232869738, getCategoryDataSynchronous, driver, "KmmMamiDB.sq",
      "getCategoryDataSynchronous", "SELECT * FROM CategoryTable") { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getString(5)!!,
      cursor.getLong(6)!!,
      cursor.getLong(7)!!,
      cursor.getLong(8)!!,
      cursor.getLong(9)!!,
      cursor.getString(10)!!
    )
  }

  public override fun getCategoryDataSynchronous(): Query<CategoryTable> =
      getCategoryDataSynchronous { primaryKey, id, name, nameEng, nameKor, imageUrl, depth,
      orderData, parentId, productCount, rootCategoryName ->
    CategoryTable(
      primaryKey,
      id,
      name,
      nameEng,
      nameKor,
      imageUrl,
      depth,
      orderData,
      parentId,
      productCount,
      rootCategoryName
    )
  }

  public override fun <T : Any> getCategoryByRootCategoryName(rootCategoryName: String, mapper: (
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
  ) -> T): Query<T> = GetCategoryByRootCategoryNameQuery(rootCategoryName) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getString(5)!!,
      cursor.getLong(6)!!,
      cursor.getLong(7)!!,
      cursor.getLong(8)!!,
      cursor.getLong(9)!!,
      cursor.getString(10)!!
    )
  }

  public override fun getCategoryByRootCategoryName(rootCategoryName: String): Query<CategoryTable>
      = getCategoryByRootCategoryName(rootCategoryName) { primaryKey, id, name, nameEng, nameKor,
      imageUrl, depth, orderData, parentId, productCount, rootCategoryName_ ->
    CategoryTable(
      primaryKey,
      id,
      name,
      nameEng,
      nameKor,
      imageUrl,
      depth,
      orderData,
      parentId,
      productCount,
      rootCategoryName_
    )
  }

  public override fun <T : Any> getCategoryDataId(id: Long, mapper: (
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
  ) -> T): Query<T> = GetCategoryDataIdQuery(id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getString(5)!!,
      cursor.getLong(6)!!,
      cursor.getLong(7)!!,
      cursor.getLong(8)!!,
      cursor.getLong(9)!!,
      cursor.getString(10)!!
    )
  }

  public override fun getCategoryDataId(id: Long): Query<CategoryTable> = getCategoryDataId(id) {
      primaryKey, id_, name, nameEng, nameKor, imageUrl, depth, orderData, parentId, productCount,
      rootCategoryName ->
    CategoryTable(
      primaryKey,
      id_,
      name,
      nameEng,
      nameKor,
      imageUrl,
      depth,
      orderData,
      parentId,
      productCount,
      rootCategoryName
    )
  }

  public override fun getRootCategoryNameList(): Query<String> = Query(-1009805952,
      getRootCategoryNameList, driver, "KmmMamiDB.sq", "getRootCategoryNameList",
      "SELECT DISTINCT rootCategoryName FROM CategoryTable") { cursor ->
    cursor.getString(0)!!
  }

  public override fun getRootCategoryId(rootCategoryName: String): Query<Long> =
      GetRootCategoryIdQuery(rootCategoryName) { cursor ->
    cursor.getLong(0)!!
  }

  public override fun <T : Any> getParentDataFromChild(parentId: Long, mapper: (
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
  ) -> T): Query<T> = GetParentDataFromChildQuery(parentId) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getString(5)!!,
      cursor.getLong(6)!!,
      cursor.getLong(7)!!,
      cursor.getLong(8)!!,
      cursor.getLong(9)!!,
      cursor.getString(10)!!
    )
  }

  public override fun getParentDataFromChild(parentId: Long): Query<CategoryTable> =
      getParentDataFromChild(parentId) { primaryKey, id, name, nameEng, nameKor, imageUrl, depth,
      orderData, parentId_, productCount, rootCategoryName ->
    CategoryTable(
      primaryKey,
      id,
      name,
      nameEng,
      nameKor,
      imageUrl,
      depth,
      orderData,
      parentId_,
      productCount,
      rootCategoryName
    )
  }

  public override fun <T : Any> getChildCategoryDataList(parentId: Long, mapper: (
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
  ) -> T): Query<T> = GetChildCategoryDataListQuery(parentId) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getLong(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getString(5)!!,
      cursor.getLong(6)!!,
      cursor.getLong(7)!!,
      cursor.getLong(8)!!,
      cursor.getLong(9)!!,
      cursor.getString(10)!!
    )
  }

  public override fun getChildCategoryDataList(parentId: Long): Query<CategoryTable> =
      getChildCategoryDataList(parentId) { primaryKey, id, name, nameEng, nameKor, imageUrl, depth,
      orderData, parentId_, productCount, rootCategoryName ->
    CategoryTable(
      primaryKey,
      id,
      name,
      nameEng,
      nameKor,
      imageUrl,
      depth,
      orderData,
      parentId_,
      productCount,
      rootCategoryName
    )
  }

  public override fun <T : Any> getCategoryDataInRecentProduct(mapper: (
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
  ) -> T): Query<T> = Query(1901698704, getCategoryDataInRecentProduct, driver, "KmmMamiDB.sq",
      "getCategoryDataInRecentProduct",
      "SELECT * FROM RecentProductTable ORDER BY updateTime DESC") { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getString(5)!!,
      cursor.getString(6)!!,
      cursor.getString(7)!!,
      cursor.getString(8)!!,
      cursor.getLong(9)!! == 1L,
      cursor.getLong(10)!! == 1L,
      cursor.getLong(11)!!
    )
  }

  public override fun getCategoryDataInRecentProduct(): Query<RecentProductTable> =
      getCategoryDataInRecentProduct { _id, id, name, sellerName, sellerId, thumbnailUrl, price,
      salePrice, salePercent, isSell, isPurchased, updateTime ->
    RecentProductTable(
      _id,
      id,
      name,
      sellerName,
      sellerId,
      thumbnailUrl,
      price,
      salePrice,
      salePercent,
      isSell,
      isPurchased,
      updateTime
    )
  }

  public override fun <T : Any> getCategoryDataByOffsetInRecentProduct(
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
  ): Query<T> = GetCategoryDataByOffsetInRecentProductQuery(limit, offset) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getString(5)!!,
      cursor.getString(6)!!,
      cursor.getString(7)!!,
      cursor.getString(8)!!,
      cursor.getLong(9)!! == 1L,
      cursor.getLong(10)!! == 1L,
      cursor.getLong(11)!!
    )
  }

  public override fun getCategoryDataByOffsetInRecentProduct(limit: Long, offset: Long):
      Query<RecentProductTable> = getCategoryDataByOffsetInRecentProduct(limit, offset) { _id, id,
      name, sellerName, sellerId, thumbnailUrl, price, salePrice, salePercent, isSell, isPurchased,
      updateTime ->
    RecentProductTable(
      _id,
      id,
      name,
      sellerName,
      sellerId,
      thumbnailUrl,
      price,
      salePrice,
      salePercent,
      isSell,
      isPurchased,
      updateTime
    )
  }

  public override fun <T : Any> getCategoryDataByIdInRecentProduct(id: String, mapper: (
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
  ) -> T): Query<T> = GetCategoryDataByIdInRecentProductQuery(id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getString(5)!!,
      cursor.getString(6)!!,
      cursor.getString(7)!!,
      cursor.getString(8)!!,
      cursor.getLong(9)!! == 1L,
      cursor.getLong(10)!! == 1L,
      cursor.getLong(11)!!
    )
  }

  public override fun getCategoryDataByIdInRecentProduct(id: String): Query<RecentProductTable> =
      getCategoryDataByIdInRecentProduct(id) { _id, id_, name, sellerName, sellerId, thumbnailUrl,
      price, salePrice, salePercent, isSell, isPurchased, updateTime ->
    RecentProductTable(
      _id,
      id_,
      name,
      sellerName,
      sellerId,
      thumbnailUrl,
      price,
      salePrice,
      salePercent,
      isSell,
      isPurchased,
      updateTime
    )
  }

  public override fun insert(
    id: String,
    isBookmark: Boolean,
    dataType: String
  ): Unit {
    driver.execute(1812022648, """
    |INSERT OR REPLACE INTO BookmarkTable(id, isBookmark, dataType)
    |VALUES (?, ?, ?)
    """.trimMargin(), 3) {
      bindString(1, id)
      bindLong(2, if (isBookmark) 1L else 0L)
      bindString(3, dataType)
    }
    notifyQueries(1812022648, {database.kmmMamiDBQueries.getBookMarkListData +
        database.kmmMamiDBQueries.getBookMarkData + database.kmmMamiDBQueries.getBookMarkDataSync +
        database.kmmMamiDBQueries.selectAll})
  }

  public override fun insertBookmarkObject(BookmarkTable: BookmarkTable): Unit {
    driver.execute(1819481005, """
    |INSERT OR REPLACE INTO BookmarkTable(id, isBookmark, dataType)
    |VALUES (?, ?, ?)
    """.trimMargin(), 3) {
      bindString(1, BookmarkTable.id)
      bindLong(2, if (BookmarkTable.isBookmark) 1L else 0L)
      bindString(3, BookmarkTable.dataType)
    }
    notifyQueries(1819481005, {database.kmmMamiDBQueries.getBookMarkListData +
        database.kmmMamiDBQueries.getBookMarkData + database.kmmMamiDBQueries.getBookMarkDataSync +
        database.kmmMamiDBQueries.selectAll})
  }

  public override fun updateBookmark(
    id: String,
    isBookmark: Boolean,
    dataType: String,
    id_: String
  ): Unit {
    driver.execute(761445598, """
    |UPDATE BookmarkTable
    |SET id = ?, isBookmark = ?, dataType = ?
    |WHERE id = ?
    """.trimMargin(), 4) {
      bindString(1, id)
      bindLong(2, if (isBookmark) 1L else 0L)
      bindString(3, dataType)
      bindString(4, id_)
    }
    notifyQueries(761445598, {database.kmmMamiDBQueries.getBookMarkListData +
        database.kmmMamiDBQueries.getBookMarkData + database.kmmMamiDBQueries.getBookMarkDataSync +
        database.kmmMamiDBQueries.selectAll})
  }

  public override fun removeAllBookmark(): Unit {
    driver.execute(25552564, """DELETE FROM BookmarkTable""", 0)
    notifyQueries(25552564, {database.kmmMamiDBQueries.getBookMarkListData +
        database.kmmMamiDBQueries.getBookMarkData + database.kmmMamiDBQueries.getBookMarkDataSync +
        database.kmmMamiDBQueries.selectAll})
  }

  public override fun insertCategoryData(
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
  ): Unit {
    driver.execute(-1277651104, """
    |INSERT OR REPLACE INTO CategoryTable(id, name, nameEng, nameKor, imageUrl, depth, orderData, parentId, productCount, rootCategoryName)
    |VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """.trimMargin(), 10) {
      bindLong(1, id)
      bindString(2, name)
      bindString(3, nameEng)
      bindString(4, nameKor)
      bindString(5, imageUrl)
      bindLong(6, depth)
      bindLong(7, orderData)
      bindLong(8, parentId)
      bindLong(9, productCount)
      bindString(10, rootCategoryName)
    }
    notifyQueries(-1277651104, {database.kmmMamiDBQueries.getRootCategoryId +
        database.kmmMamiDBQueries.getRootCategoryNameList +
        database.kmmMamiDBQueries.getCategoryByRootCategoryName +
        database.kmmMamiDBQueries.getCategoryData + database.kmmMamiDBQueries.getCategoryDataId +
        database.kmmMamiDBQueries.getCategoryDataSynchronous +
        database.kmmMamiDBQueries.getChildCategoryDataList +
        database.kmmMamiDBQueries.getParentDataFromChild})
  }

  public override fun deleteCategoryData(): Unit {
    driver.execute(-1508409518, """DELETE FROM CategoryTable""", 0)
    notifyQueries(-1508409518, {database.kmmMamiDBQueries.getRootCategoryId +
        database.kmmMamiDBQueries.getRootCategoryNameList +
        database.kmmMamiDBQueries.getCategoryByRootCategoryName +
        database.kmmMamiDBQueries.getCategoryData + database.kmmMamiDBQueries.getCategoryDataId +
        database.kmmMamiDBQueries.getCategoryDataSynchronous +
        database.kmmMamiDBQueries.getChildCategoryDataList +
        database.kmmMamiDBQueries.getParentDataFromChild})
  }

  public override fun insertProductData(RecentProductTable: RecentProductTable): Unit {
    driver.execute(1085335713, """
    |INSERT OR REPLACE INTO RecentProductTable(id, name, sellerName, sellerId, thumbnailUrl, price, salePrice, salePercent, isSell, isPurchased, updateTime)
    |VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """.trimMargin(), 11) {
      bindString(1, RecentProductTable.id)
      bindString(2, RecentProductTable.name)
      bindString(3, RecentProductTable.sellerName)
      bindString(4, RecentProductTable.sellerId)
      bindString(5, RecentProductTable.thumbnailUrl)
      bindString(6, RecentProductTable.price)
      bindString(7, RecentProductTable.salePrice)
      bindString(8, RecentProductTable.salePercent)
      bindLong(9, if (RecentProductTable.isSell) 1L else 0L)
      bindLong(10, if (RecentProductTable.isPurchased) 1L else 0L)
      bindLong(11, RecentProductTable.updateTime)
    }
    notifyQueries(1085335713, {database.kmmMamiDBQueries.getCategoryDataByOffsetInRecentProduct +
        database.kmmMamiDBQueries.getCategoryDataByIdInRecentProduct +
        database.kmmMamiDBQueries.getCategoryDataInRecentProduct})
  }

  public override fun updateProductData(RecentProductTable: RecentProductTable): Unit {
    driver.execute(1779828881, """
    |INSERT OR REPLACE INTO RecentProductTable(id, name, sellerName, sellerId, thumbnailUrl, price, salePrice, salePercent, isSell, isPurchased, updateTime)
    |VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """.trimMargin(), 11) {
      bindString(1, RecentProductTable.id)
      bindString(2, RecentProductTable.name)
      bindString(3, RecentProductTable.sellerName)
      bindString(4, RecentProductTable.sellerId)
      bindString(5, RecentProductTable.thumbnailUrl)
      bindString(6, RecentProductTable.price)
      bindString(7, RecentProductTable.salePrice)
      bindString(8, RecentProductTable.salePercent)
      bindLong(9, if (RecentProductTable.isSell) 1L else 0L)
      bindLong(10, if (RecentProductTable.isPurchased) 1L else 0L)
      bindLong(11, RecentProductTable.updateTime)
    }
    notifyQueries(1779828881, {database.kmmMamiDBQueries.getCategoryDataByOffsetInRecentProduct +
        database.kmmMamiDBQueries.getCategoryDataByIdInRecentProduct +
        database.kmmMamiDBQueries.getCategoryDataInRecentProduct})
  }

  public override fun deleteProductDataInRecentProduct(id: String): Unit {
    driver.execute(-1665848704, """DELETE FROM RecentProductTable WHERE id = ?""", 1) {
      bindString(1, id)
    }
    notifyQueries(-1665848704, {database.kmmMamiDBQueries.getCategoryDataByOffsetInRecentProduct +
        database.kmmMamiDBQueries.getCategoryDataByIdInRecentProduct +
        database.kmmMamiDBQueries.getCategoryDataInRecentProduct})
  }

  public override fun deleteProductDataAllInRecentProduct(): Unit {
    driver.execute(-5424675, """DELETE FROM RecentProductTable""", 0)
    notifyQueries(-5424675, {database.kmmMamiDBQueries.getCategoryDataByOffsetInRecentProduct +
        database.kmmMamiDBQueries.getCategoryDataByIdInRecentProduct +
        database.kmmMamiDBQueries.getCategoryDataInRecentProduct})
  }

  public override fun upserBookmark(
    isBookmark: Boolean,
    dataType: String,
    id: String
  ): Unit {
    driver.execute(1187759437, """
    |UPDATE BookmarkTable
    |  SET isBookmark = ?, dataType = ?
    |  WHERE id = ?
    """.trimMargin(), 3) {
      bindLong(1, if (isBookmark) 1L else 0L)
      bindString(2, dataType)
      bindString(3, id)
    }
    driver.execute(1187759438, """
    |INSERT OR IGNORE INTO BookmarkTable (id, isBookmark, dataType)
    |  VALUES(?, ?, ?)
    """.trimMargin(), 3) {
      bindString(1, id)
      bindLong(2, if (isBookmark) 1L else 0L)
      bindString(3, dataType)
    }
    notifyQueries(1248161948, {database.kmmMamiDBQueries.getBookMarkListData +
        database.kmmMamiDBQueries.getBookMarkData + database.kmmMamiDBQueries.getBookMarkDataSync +
        database.kmmMamiDBQueries.selectAll})
  }

  public override fun deleteBookMarkData(type: String): Unit {
    driver.execute(781891803, """DELETE FROM BookmarkTable WHERE dataType = ?""", 1) {
      bindString(1, type)
    }
    notifyQueries(81260458, {database.kmmMamiDBQueries.getBookMarkListData +
        database.kmmMamiDBQueries.getBookMarkData + database.kmmMamiDBQueries.getBookMarkDataSync +
        database.kmmMamiDBQueries.selectAll})
  }

  private inner class GetBookMarkDataQuery<out T : Any>(
    public val type: String,
    public val id: String,
    mapper: (SqlCursor) -> T
  ) : Query<T>(getBookMarkData, mapper) {
    public override fun execute(): SqlCursor = driver.executeQuery(-1765762889,
        """SELECT * FROM BookmarkTable WHERE dataType = ? AND id = ?""", 2) {
      bindString(1, type)
      bindString(2, id)
    }

    public override fun toString(): String = "KmmMamiDB.sq:getBookMarkData"
  }

  private inner class GetBookMarkListDataQuery<out T : Any>(
    public val type: String,
    mapper: (SqlCursor) -> T
  ) : Query<T>(getBookMarkListData, mapper) {
    public override fun execute(): SqlCursor = driver.executeQuery(-2072383499,
        """SELECT * FROM BookmarkTable WHERE dataType = ?""", 1) {
      bindString(1, type)
    }

    public override fun toString(): String = "KmmMamiDB.sq:getBookMarkListData"
  }

  private inner class GetBookMarkDataSyncQuery<out T : Any>(
    public val type: String,
    public val id: String,
    mapper: (SqlCursor) -> T
  ) : Query<T>(getBookMarkDataSync, mapper) {
    public override fun execute(): SqlCursor = driver.executeQuery(-1628507150,
        """SELECT * FROM BookmarkTable WHERE dataType = ? AND id = ?""", 2) {
      bindString(1, type)
      bindString(2, id)
    }

    public override fun toString(): String = "KmmMamiDB.sq:getBookMarkDataSync"
  }

  private inner class GetCategoryByRootCategoryNameQuery<out T : Any>(
    public val rootCategoryName: String,
    mapper: (SqlCursor) -> T
  ) : Query<T>(getCategoryByRootCategoryName, mapper) {
    public override fun execute(): SqlCursor = driver.executeQuery(-97933033,
        """SELECT * FROM CategoryTable WHERE rootCategoryName = ?""", 1) {
      bindString(1, rootCategoryName)
    }

    public override fun toString(): String = "KmmMamiDB.sq:getCategoryByRootCategoryName"
  }

  private inner class GetCategoryDataIdQuery<out T : Any>(
    public val id: Long,
    mapper: (SqlCursor) -> T
  ) : Query<T>(getCategoryDataId, mapper) {
    public override fun execute(): SqlCursor = driver.executeQuery(949458394,
        """SELECT * FROM CategoryTable WHERE id = ?""", 1) {
      bindLong(1, id)
    }

    public override fun toString(): String = "KmmMamiDB.sq:getCategoryDataId"
  }

  private inner class GetRootCategoryIdQuery<out T : Any>(
    public val rootCategoryName: String,
    mapper: (SqlCursor) -> T
  ) : Query<T>(getRootCategoryId, mapper) {
    public override fun execute(): SqlCursor = driver.executeQuery(-2032069102,
        """SELECT DISTINCT parentId FROM CategoryTable WHERE depth = 2 AND rootCategoryName = ?""",
        1) {
      bindString(1, rootCategoryName)
    }

    public override fun toString(): String = "KmmMamiDB.sq:getRootCategoryId"
  }

  private inner class GetParentDataFromChildQuery<out T : Any>(
    public val parentId: Long,
    mapper: (SqlCursor) -> T
  ) : Query<T>(getParentDataFromChild, mapper) {
    public override fun execute(): SqlCursor = driver.executeQuery(2017879047,
        """SELECT * FROM CategoryTable WHERE depth = 2 AND parentId = ?""", 1) {
      bindLong(1, parentId)
    }

    public override fun toString(): String = "KmmMamiDB.sq:getParentDataFromChild"
  }

  private inner class GetChildCategoryDataListQuery<out T : Any>(
    public val parentId: Long,
    mapper: (SqlCursor) -> T
  ) : Query<T>(getChildCategoryDataList, mapper) {
    public override fun execute(): SqlCursor = driver.executeQuery(1884796683,
        """SELECT * FROM CategoryTable WHERE depth = 3 AND parentId = ?""", 1) {
      bindLong(1, parentId)
    }

    public override fun toString(): String = "KmmMamiDB.sq:getChildCategoryDataList"
  }

  private inner class GetCategoryDataByOffsetInRecentProductQuery<out T : Any>(
    public val limit: Long,
    public val offset: Long,
    mapper: (SqlCursor) -> T
  ) : Query<T>(getCategoryDataByOffsetInRecentProduct, mapper) {
    public override fun execute(): SqlCursor = driver.executeQuery(-525674394,
        """SELECT * FROM RecentProductTable ORDER BY updateTime DESC LIMIT ? OFFSET ?""", 2) {
      bindLong(1, limit)
      bindLong(2, offset)
    }

    public override fun toString(): String = "KmmMamiDB.sq:getCategoryDataByOffsetInRecentProduct"
  }

  private inner class GetCategoryDataByIdInRecentProductQuery<out T : Any>(
    public val id: String,
    mapper: (SqlCursor) -> T
  ) : Query<T>(getCategoryDataByIdInRecentProduct, mapper) {
    public override fun execute(): SqlCursor = driver.executeQuery(1013375966,
        """SELECT * FROM RecentProductTable WHERE id = ?""", 1) {
      bindString(1, id)
    }

    public override fun toString(): String = "KmmMamiDB.sq:getCategoryDataByIdInRecentProduct"
  }
}
