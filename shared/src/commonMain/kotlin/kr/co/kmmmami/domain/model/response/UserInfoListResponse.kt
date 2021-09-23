package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by jangsc@brandi.co.kr on 12/16/20
 */
@Serializable
data class UserInfoListResponse(
    @SerialName( "data")
    val dataList: List<UserInfoData>? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class UserInfoData(
    @SerialName( "nickname")
    val nickname: String = "",
    @SerialName( "photo_url")
    val photoUrl: String = "",
    @SerialName( "member_no")
    val memberNo: String = "",
)
