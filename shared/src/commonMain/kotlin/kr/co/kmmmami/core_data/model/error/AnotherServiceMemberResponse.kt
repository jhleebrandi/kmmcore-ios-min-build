package kr.co.kmmmami.core_data.model.error

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class AnotherServiceMemberResponse(
    @Transient
    val data: Any? = null,
    @SerialName("meta")
    override val meta: Meta? = null,
) : Response()
