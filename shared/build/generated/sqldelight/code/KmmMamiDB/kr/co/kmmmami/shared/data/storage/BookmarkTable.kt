package kr.co.kmmmami.shared.`data`.storage

import kotlin.Boolean
import kotlin.String

public data class BookmarkTable(
  public val id: String,
  public val isBookmark: Boolean,
  public val dataType: String
) {
  public override fun toString(): String = """
  |BookmarkTable [
  |  id: $id
  |  isBookmark: $isBookmark
  |  dataType: $dataType
  |]
  """.trimMargin()
}
