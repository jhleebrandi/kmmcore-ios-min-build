package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class ImagesResponse(
    @SerialName( "data")
    val data: ImagesData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class ImagesData(
    @SerialName( "splash_image_url")
    val splashImageData: SplashImageData? = null,
    @SerialName( "login_image_url")
    val loginImageData: LoginImageData? = null,
)

@Serializable
data class SplashImageData(
    @SerialName( "android")
    val url: String = "",
)

@Serializable
data class LoginImageData(
    @SerialName( "android")
    val url: String = "",
)
