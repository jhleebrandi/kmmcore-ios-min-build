package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by jangsc@brandi.co.kr on 12/16/20
 */
@Serializable
data class UserSelfPointResponse(
    @SerialName( "data")
    val data: UserSelfPointData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class UserSelfPointData(
    @SerialName( "extinction_point")
    val extinctionPoint: Long = 0L,
    @SerialName( "points")
    val pointList: List<PointsData> = emptyList(),
    @SerialName( "user_point")
    val userPoint: Long = 0L,
)

@Serializable
data class PointsData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "text")
    val text: String = "",
    @SerialName( "point")
    val point: Long = 0L,
    @SerialName( "created_time")
    val createdTime: String = "",
)
