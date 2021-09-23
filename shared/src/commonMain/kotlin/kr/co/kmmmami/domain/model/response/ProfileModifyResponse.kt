package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class ProfileModifyResponse(
    @SerialName( "data")
    val data: ProfileModifyData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class ProfileModifyData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "text")
    val text: String = "",
    @SerialName( "height")
    val height: Int = 0,
    @SerialName( "weight")
    val weight: Int = 0,
    @SerialName( "completed_phrase")
    val completedPhrase: ProfileCompletedPhraseData? = null,
)

@Serializable
data class ProfileCompletedPhraseData(
    @SerialName( "title")
    var title: String = "",
    @SerialName( "contents")
    var contents: String = "",
    @SerialName( "button_text")
    var button_text: String = "",
)
