package kr.co.kmmmami.domain.model

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Parcelize
@Serializable
data class SectionGroupData(
    @SerialName("id")
    val id: String = "",
    @SerialName("name")
    val name: String = "",
) : Parcelable
