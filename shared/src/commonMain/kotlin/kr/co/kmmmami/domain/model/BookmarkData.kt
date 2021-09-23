package kr.co.kmmmami.domain.model

/**
 * Created by jangsc@brandi.co.kr on 1/5/21
 */
data class BookmarkData(
    var id: String = "",
    var isBookmark: Boolean = false,
    var dataType: BOOKMARK_DATA_TYPE = BOOKMARK_DATA_TYPE.PRODUCT,
)
