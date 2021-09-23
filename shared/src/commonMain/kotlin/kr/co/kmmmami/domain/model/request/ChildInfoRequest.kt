package kr.co.kmmmami.domain.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KidsRequest(
    @SerialName("kids")
    val kids: List<KidItem>,
)
