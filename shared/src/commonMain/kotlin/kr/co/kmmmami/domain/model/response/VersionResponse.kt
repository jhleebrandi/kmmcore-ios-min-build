package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by jangsc@brandi.co.kr on 12/16/20
 */
@Serializable
data class VersionResponse(
    @SerialName("data")
    val data: VersionData? = null,
    @SerialName("meta")
    override val meta: Meta? = null,
    @SerialName("top_banners")
    val topBannerList: List<BannerListData> = emptyList(),
) : Response()

@Serializable
data class VersionData(
    @SerialName("android_app_compat")
    val androidAppCompat: Int = 0,
    @SerialName("package_name")
    val packageName: String = "",
    @SerialName("brand")
    val brand: Int = 0,
    @SerialName("item_category")
    val itemCategory: Int = 0,
    @SerialName("login_image")
    val loginImage: Int = 0,
    @SerialName("splash_image")
    val splashImage: Int = 0,
    @SerialName("url_version")
    val urlVersion: Int = 0,
    @SerialName("text_version")
    val textVersion: Int = 0,
)
