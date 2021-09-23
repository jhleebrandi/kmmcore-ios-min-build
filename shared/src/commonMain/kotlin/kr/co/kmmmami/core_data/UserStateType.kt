package kr.co.kmmmami.core_data

enum class UserStateType {
    UNKNOWN, // 알수없는
    NORMAL, // 인증
    DORMANT, // 휴먼
    UNQUALIFIED, // 탈퇴
    UNAUTHORIZED // 미인증
}
