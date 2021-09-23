package kr.co.kmmmami.shared.`data`.storage

import kotlin.Boolean
import kotlin.Long
import kotlin.String

public data class RecentProductTable(
  public val _id: Long,
  public val id: String,
  public val name: String,
  public val sellerName: String,
  public val sellerId: String,
  public val thumbnailUrl: String,
  public val price: String,
  public val salePrice: String,
  public val salePercent: String,
  public val isSell: Boolean,
  public val isPurchased: Boolean,
  public val updateTime: Long
) {
  public override fun toString(): String = """
  |RecentProductTable [
  |  _id: $_id
  |  id: $id
  |  name: $name
  |  sellerName: $sellerName
  |  sellerId: $sellerId
  |  thumbnailUrl: $thumbnailUrl
  |  price: $price
  |  salePrice: $salePrice
  |  salePercent: $salePercent
  |  isSell: $isSell
  |  isPurchased: $isPurchased
  |  updateTime: $updateTime
  |]
  """.trimMargin()
}
