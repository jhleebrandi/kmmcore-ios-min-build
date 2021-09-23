package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelize
import dev.icerock.moko.parcelize.Parcelable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class CompletedPhraseResponse(
    @SerialName( "data")
    val data: CompletedPhrase? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Parcelize
@Serializable
data class CompletedPhrase(
    @SerialName( "completed_phrase")
    val completedPhraseData: CompletedPhraseData? = null,
) : Parcelable

@Parcelize
@Serializable
data class CompletedPhraseData(
    @SerialName( "title")
    val title: String = "",
    @SerialName( "contents")
    val contents: String = "",
    @SerialName( "sub_contents_1")
    val subContents1: String? = "",
    @SerialName( "sub_contents_2")
    val subContents2: String? = "",
    @SerialName( "sub_contents_3")
    val subContents3: String? = "",
    @SerialName( "sub_contents_4")
    val subContents4: String? = "",
    @SerialName( "sub_contents_5")
    val subContents5: String? = "",
    @SerialName( "button_text_left")
    val buttonTextLeft: String? = "",
    @SerialName( "button_text")
    val buttonText: String = "",
    @SerialName( "brandi_image_url")
    val brandiImageUrl: String = "",
    @SerialName( "is_coupon_issue")
    val isCouponIssue: Boolean = false,
) : Parcelable
