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
data class CheckOutResponse(
    @SerialName( "data")
    val data: CheckOutData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Parcelize
@Serializable
data class CheckOutData(
    @SerialName( "checkout_id")
    val checkOutId: String = "",
) : Parcelable
