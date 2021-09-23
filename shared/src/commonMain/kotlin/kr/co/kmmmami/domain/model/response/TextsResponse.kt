package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by jangsc@brandi.co.kr on 12/16/20
 */
@Serializable
data class TextsResponse(
    @SerialName( "data")
    val data: TextData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class TextData(
    @SerialName( "common")
    val common: CommonData? = null,
)

@Serializable
data class CommonData(
    @SerialName( "footer")
    val footer: FooterData? = null,
)

@Serializable
data class FooterData(
    @SerialName( "app")
    val app: String = "",
)
