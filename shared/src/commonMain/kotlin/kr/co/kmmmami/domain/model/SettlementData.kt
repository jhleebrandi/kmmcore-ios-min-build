package kr.co.kmmmami.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class SettlementData(
    @SerialName("code")
    val code: String = "",
    @SerialName("name")
    val name: String = "",
    @SerialName("bank_name")
    val bankName: String = "",
    @SerialName("bank_account_number")
    val bankAccountNumber: String = "",
    @SerialName("bank_accounter")
    val accountHolder: String = "",
    @SerialName("bank_close_time")
    val bankCloseTime: Long = 0L
)
