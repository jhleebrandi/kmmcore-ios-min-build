package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class MyBannersResponse(
    @SerialName( "data")
    val data: MyBannersData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class MyBannersData(
    @SerialName( "gnb_my_banners")
    val gnbMyBannerList: List<BannerListData> = emptyList(),
)
