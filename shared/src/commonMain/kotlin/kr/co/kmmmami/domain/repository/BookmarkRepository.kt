package kr.co.kmmmami.domain.repository

import kr.co.kmmmami.domain.model.BOOKMARK_DATA_TYPE
import kr.co.kmmmami.domain.model.BookmarkData

/**
 * Created by kdy3@brandi.co.kr on 2021/02/09
 * 기존 BookMarkHelper 대응
 */
interface BookmarkRepository {

    /**
     * id 로 저장
     * @param bookmarks 추가하려는 북마크의 id 리스트
     * @param type [BOOKMARK_DATA_TYPE]
     */
    fun addBookMarkList(bookmarks: List<String>, type: BOOKMARK_DATA_TYPE)

    fun updateBookMark(bookmark: BookmarkData)

    fun isBookMark(id: String, isBookmark: Boolean, type: BOOKMARK_DATA_TYPE): Boolean

    fun getBookMarkData(id: String, type: BOOKMARK_DATA_TYPE): BookmarkData?
    fun getBookMarkDataList(type: BOOKMARK_DATA_TYPE): List<BookmarkData>
    fun getProductBookmarkIdList(): List<String>
    fun getStoreBookmarkIdList(): List<String>
}
