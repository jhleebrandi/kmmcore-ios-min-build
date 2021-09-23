package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class MyProfileResponse(
    @SerialName( "data")
    val data: MyProfileData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class MyProfileData(
    @SerialName( "id")
    val id: String? = null,
    @SerialName( "certified_name")
    val certifiedName: String? = null,
    @SerialName( "name")
    val name: String? = null,
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "gender")
    val gender: String? = null,
    @SerialName( "birth_date")
    val birthDate: String?,
    @SerialName( "text")
    val text: String = "",
    @SerialName( "point")
    val point: Long = 0L,
    @SerialName( "weight")
    val weight: Int = 0,
    @SerialName( "height")
    val height: Int = 0,
    @SerialName( "is_push")
    val isPush: Boolean = false,
    @SerialName( "state")
    val state: Int = 0,
    @SerialName( "telephone")
    val telephone: String? = "",
    @SerialName( "email")
    val email: String? = "",
    @SerialName( "created_time")
    val createdTime: Long = 0L,
    @SerialName( "certification")
    val certification: CertificationData? = null,
    @SerialName( "age")
    val age: Int = 0,
    @SerialName( "coupon_count")
    val couponCount: Int = 0,
    @SerialName( "order_info")
    val orderInfo: OrderInfoData? = null,
    @SerialName( "seller_bookmark_count")
    val sellerBookmarkCount: Int = 0,
    @SerialName( "signup_path")
    val signUpPath: String = "",
    @SerialName( "last_purchase_time")
    val lastPurchaseTime: Long = 0L,
    @SerialName( "recommend_code")
    val recommendCode: String = "",
    @SerialName( "recommended_code")
    val recommendedCode: String = "",
    @SerialName( "writable_review_count")
    val writableReviewCount: Int = 0,
    @SerialName( "push")
    val push: PushData? = null,
    @SerialName( "mber_idvrfy_type")
    val mberIdvrfyType: String = "", // 1: 본인인증, 2: 휴대폰 인증. 인증레벨, 미인증이나 탈퇴도 전부 2
    @SerialName( "is_available_name_update")
    val isAvailableNameUpdate: Boolean = true,

    // 앱 내부에서 사용
    var isProfileChange: Boolean = false,
//    @Transient
//    var profileUri: Uri? = null,
)

@Serializable
data class CertificationData(
    @SerialName( "gender")
    val gender: String? = null,
    @SerialName( "birth_date")
    val birthday: String? = null,
)

@Serializable
data class OrderInfoData(
    @SerialName( "total_order_complete_count")
    val totalOrderCompleteCount: Int = 0,
    @SerialName( "total_order_complete_price")
    val totalOrderCompletePrice: Int = 0,
    @SerialName( "brand_order_complete_count")
    val brandOrderCompleteCount: Int = 0,
    @SerialName( "shoppingmall_order_complete_count")
    val shoppingMallOrderCompleteCount: Int = 0,
    @SerialName( "grooming_order_complete_count")
    val groomingOrderCompleteCount: Int = 0,
    @SerialName( "total_price")
    val totalPrice: Double = 0.0,
    @SerialName( "total_order_detail_count")
    val totalOrderDetailCount: Int = 0,
    @SerialName( "total_order_detail_cancel_count")
    val totalOrderDetailCancelCount: Int = 0,
)

@Serializable
data class PushData(
    @SerialName( "is_marketing")
    val isMarketing: Boolean = false,
    @SerialName( "is_night")
    val isNight: Boolean = false,
    @SerialName( "popup")
    val popup: PushPopupData? = null,
    @SerialName( "marketing_updated_time")
    val marketingUpdatedTime: Long = 0L
)

@Serializable
data class PushPopupData(
    @SerialName( "invisible_day")
    val invisibleDay: Int = 0,
    @SerialName( "is_visible")
    val isVisible: Boolean = false,
)

data class EditableProfileData(
    val name: String,
    val birthDate: String,
    val gender: String,
    val height: String,
    val weight: String,
    val email: String,
    val telephone: String,
    val verificationType: Int,
    val typeValue: String,
    val updateName: String?,
)
