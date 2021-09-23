package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by jangsc@brandi.co.kr on 12/16/20
 */
@Serializable
data class UserPushResponse(
    @SerialName( "data")
    val data: UserPushData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class UserPushData(
    @SerialName( "completed_time")
    val completedTime: Long = 0L,
    @SerialName( "push")
    val push: PushData? = null,
)
