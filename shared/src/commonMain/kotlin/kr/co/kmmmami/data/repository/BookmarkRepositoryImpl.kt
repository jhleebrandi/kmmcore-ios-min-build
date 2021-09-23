package kr.co.kmmmami.data.repository

import kr.co.kmmmami.data.local.storage.Database
import kr.co.kmmmami.domain.model.BOOKMARK_DATA_TYPE
import kr.co.kmmmami.domain.model.BookmarkData
import kr.co.kmmmami.domain.repository.BookmarkRepository
import kr.co.kmmmami.shared.data.storage.BookmarkTable
import kr.co.kmmmami.shared.data.storage.KmmMamiDBQueries


/**
 * Created by kdy3@brandi.co.kr on 2021/02/09
 */
class BookmarkRepositoryImpl(appDatabase: Database) : BookmarkRepository {
    private val dbQuery: KmmMamiDBQueries = appDatabase.dbQuery

    override fun addBookMarkList(bookmarks: List<String>, type: BOOKMARK_DATA_TYPE) {
        val entities = bookmarks.map { id ->
            BookmarkTable(
                id = id,
                isBookmark = true,
                dataType = type.toString(),
            )
        }
        dbQuery.transaction {
            entities.forEach { data ->
                dbQuery.insertBookmarkObject(data)
            }
        }
    }

    override fun updateBookMark(bookmark: BookmarkData) {
        dbQuery.insertBookmarkObject(BookmarkMapper.toEntity(bookmark))
    }

    override fun isBookMark(
        id: String,
        isBookmark: Boolean,
        type: BOOKMARK_DATA_TYPE,
    ): Boolean {
        // 없으면 인자로 받은 isBookmark 를 반환
        val entity = dbQuery.getBookMarkData(type.toString(), id).executeAsOneOrNull() ?: return isBookmark
        return entity.isBookmark
    }

    override fun getBookMarkData(id: String, type: BOOKMARK_DATA_TYPE): BookmarkData? {
        return dbQuery.getBookMarkData(type.toString(), id).executeAsOneOrNull()?.let(BookmarkMapper::toData) ?: return null
    }

    override fun getBookMarkDataList(type: BOOKMARK_DATA_TYPE): List<BookmarkData> {
        return dbQuery.getBookMarkListData(type.toString()).executeAsList().map(BookmarkMapper::toData)
    }

    override fun getProductBookmarkIdList(): List<String> {
        return dbQuery.getBookMarkListData(BOOKMARK_DATA_TYPE.PRODUCT.toString()).executeAsList().map(BookmarkTable::id)
    }

    override fun getStoreBookmarkIdList(): List<String> {
        return dbQuery.getBookMarkListData(BOOKMARK_DATA_TYPE.STORE.toString()).executeAsList().map(BookmarkTable::id)
    }
}

object BookmarkMapper {
    fun toEntity(data: BookmarkData) = BookmarkTable(
        id = data.id,
        isBookmark = data.isBookmark,
        dataType = data.dataType.toString()
    )

    fun toData(entity: BookmarkTable) = BookmarkData(
        id = entity.id,
        isBookmark = entity.isBookmark,
        dataType = BOOKMARK_DATA_TYPE.valueOf(entity.dataType)
    )
}
