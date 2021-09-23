package kr.co.kmmmami.shared.`data`.storage

import kotlin.Long
import kotlin.String

public data class CategoryTable(
  public val primaryKey: Long,
  public val id: Long,
  public val name: String,
  public val nameEng: String,
  public val nameKor: String,
  public val imageUrl: String,
  public val depth: Long,
  public val orderData: Long,
  public val parentId: Long,
  public val productCount: Long,
  public val rootCategoryName: String
) {
  public override fun toString(): String = """
  |CategoryTable [
  |  primaryKey: $primaryKey
  |  id: $id
  |  name: $name
  |  nameEng: $nameEng
  |  nameKor: $nameKor
  |  imageUrl: $imageUrl
  |  depth: $depth
  |  orderData: $orderData
  |  parentId: $parentId
  |  productCount: $productCount
  |  rootCategoryName: $rootCategoryName
  |]
  """.trimMargin()
}
