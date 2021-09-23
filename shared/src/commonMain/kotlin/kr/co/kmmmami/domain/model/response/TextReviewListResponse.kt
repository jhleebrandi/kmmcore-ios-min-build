package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response
import kr.co.kmmmami.domain.model.TextReviewData

/**
 * Created by jangsc@brandi.co.kr on 12/16/20
 */
@Serializable
data class TextReviewListResponse(
    @SerialName( "data")
    val dataList: List<TextReviewData>? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()
