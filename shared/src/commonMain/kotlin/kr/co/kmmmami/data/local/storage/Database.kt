package kr.co.kmmmami.data.local.storage

import kr.co.kmmmami.domain.model.BOOKMARK_DATA_TYPE
import kr.co.kmmmami.domain.model.BookmarkData
import kr.co.kmmmami.shared.data.storage.BookmarkTable
import kr.co.kmmmami.shared.data.storage.KmmMamiDB

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = KmmMamiDB(databaseDriverFactory.createDriver())
    val dbQuery = database.kmmMamiDBQueries

//    val queryWrapper: Database = Database(
//        driver = driver,
//        hockeyPlayerAdapter = HockeyPlayer.Adapter(
//            positionAdapter = EnumColumnAdapter()
//        )
//    )


    fun getBookMarkData(id: String): List<BookmarkTable> {
        return dbQuery.selectAll().executeAsList()
    }

    fun getBookMarkListData(type: String): List<BookmarkTable> {
        return dbQuery.selectAll().executeAsList()
    }

    fun insertBookMarkData(data: BookmarkData) {
        dbQuery.transaction {
            dbQuery.insertBookmarkObject(BookmarkTable(data.id, data.isBookmark, data.dataType.toString()))
        }
    }

    fun insertBookMarkListData(data: List<BookmarkData>) {
        dbQuery.transaction {
            data.forEach { data ->
                dbQuery.insertBookmarkObject(BookmarkTable(data.id, data.isBookmark, data.dataType.toString()))
            }
        }
    }

    fun deleteBookMarkData(type: BOOKMARK_DATA_TYPE) {
        dbQuery.transaction {
            dbQuery.deleteBookMarkData(type.toString())
        }
    }

    fun getBookMarkDataSync(type: BOOKMARK_DATA_TYPE, id: String): BookmarkTable? {
        return dbQuery.getBookMarkDataSync(type.toString(), id).executeAsOneOrNull()
    }
}