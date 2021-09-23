package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

@Serializable
data class KidsResponse(
    @SerialName("data")
    val dataList: List<KidData>? = null,
    @SerialName("meta")
    override val meta: Meta? = null,
) : Response()

@Parcelize
@Serializable
data class KidData(
    @SerialName("id")
    var id: String? = null,
    @SerialName("name")
    var name: String = "",
    @SerialName("sexdstn")
    var gender: String = "",
    @SerialName("birth")
    var birth: String = "",
    @SerialName("photo_url")
    var photoUrl: String? = null,
    @SerialName("photo_thumbnail_url")
    var photoThumbnailUrl: String? = null,
) : Parcelable
