package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */

@Serializable
data class BannerListResponse(
    @SerialName( "data")
    val data: BannerListData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class BannerListData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
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
)
