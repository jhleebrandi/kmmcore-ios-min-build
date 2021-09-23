package kr.co.kmmmami.domain.model.request

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class WriteReviewData(
    var orderCode: String? = "",
    var productName: String? = "",
    var productId: String? = "",
    var productParentId: String? = "",
    var optionName: String? = "",
    var storeType: String? = "",
    var sellerId: String? = "",
    var reviewText: String? = "",
    var height: String = "",
    var isCloth: Boolean = false,
) : Parcelable
