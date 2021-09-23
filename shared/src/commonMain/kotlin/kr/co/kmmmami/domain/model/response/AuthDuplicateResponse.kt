package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response
import kotlinx.serialization.Serializable
/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class AuthDuplicateResponse(
    @SerialName("data")
    val data: AuthDuplicateData? = null,
    @SerialName("meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class AuthDuplicateData(
    @SerialName("is_duplicate")
    val isDuplicate: Boolean = false,
)
