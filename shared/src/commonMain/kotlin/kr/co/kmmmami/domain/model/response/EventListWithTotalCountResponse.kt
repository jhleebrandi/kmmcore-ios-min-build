package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class EventListWithTotalCountResponse(
    @SerialName( "data")
    val data: EventListWithTotalCountData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class EventListWithTotalCountData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "type")
    val type: String = "",
    @SerialName( "link")
    val link: String = "",
    @SerialName( "title")
    val title: String = "",
    @SerialName( "sub_title")
    val subTitle: String = "",
    @SerialName( "total_count")
    val totalCount: Int = 0,
    @SerialName( "event_list")
    val eventList: List<EventData> = emptyList(),
)
