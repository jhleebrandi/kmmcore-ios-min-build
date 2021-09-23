package kr.co.kmmmami.core_data.social

/**
 * Created by kdy3@brandi.co.kr on 2021/05/17
 */
enum class SOCIAL_TYPE(
    val signupTypeName: String,
    val snsName: String,
    val snsNameKR: String,
) {
    EMAIL("B", "brandi", "브랜디"),
    FACE_BOOK("F", "facebook", "페이스북"),
    GOOGLE("G", "google", "구글"),
    APPLE_ID("A", "apple", "애플"),
    KAKAO_ID("K", "kakao", "카카오"),
    NAVER_ID("N", "naver", "네이버"),
    NONE("N", "none", "없음"),
}
