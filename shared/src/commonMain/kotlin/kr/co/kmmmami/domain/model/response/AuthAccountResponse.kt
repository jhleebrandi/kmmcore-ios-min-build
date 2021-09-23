package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */

@Serializable
data class AuthAccountResponse(
    @SerialName("data")
    val data: AuthAccountData? = null,
    @SerialName("meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class AuthAccountData(
    @SerialName("brandi_token")
    val brandiToken: String = "",
    @SerialName("member_no")
    val memberNumber: String = "",
    @SerialName("nickname")
    var nickname: String = "",
    @SerialName("nickname_is_temp")
    val nickNameIsTemp: Boolean = false,
    @SerialName("is_popup")
    val isPopup: Boolean = false,
    @SerialName("popup")
    val popup: PopupData? = null,
    @SerialName("is_change_password")
    val isChangePassword: Boolean = false,
    @SerialName("is_user_recovery")
    val isUserRecovery: Boolean = false,
    @SerialName("completed_phrase")
    val completedPhrase: CompletedPhraseData? = null,
)

@Serializable
data class PopupData(
    @SerialName("title")
    val title: String = "",
    @SerialName("contents")
    val contents: String? = "",
)
