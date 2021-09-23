package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response
import kr.co.kmmmami.domain.model.PhotoReviewData

/**
 * Created by leest@brandi.co.kr on 2021/1/8
 */
@Serializable
data class PhotoReviewListResponse(
    @SerialName( "meta")
    override val meta: Meta? = null,
    @SerialName( "data")
    val dataList: List<PhotoReviewData>? = null,
) : Response()
