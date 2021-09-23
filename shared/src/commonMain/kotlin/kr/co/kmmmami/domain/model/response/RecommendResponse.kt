package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class RecommendResponse(
    @SerialName( "data")
    val data: RecommendData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class RecommendData(
    @SerialName( "recommend_code")
    val recommendCode: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "text")
    val text: String = "",
)
