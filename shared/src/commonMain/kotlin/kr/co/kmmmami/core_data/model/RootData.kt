package kr.co.kmmmami.core_data.model

import kotlinx.serialization.Serializable

@Serializable
data class RootData(
    override val meta: Meta?,
) : Response()
