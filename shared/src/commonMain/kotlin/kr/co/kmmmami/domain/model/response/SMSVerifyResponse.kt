package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * SMS 인증 요청 API 콜 결과
 * SMS 인증 키는 문자로 간다
 * ```
CASE 1 (탈퇴 회원 체크)
- is_joined : false
- join->available : false
- join->available_date : 가입가능일자
- join->start_date : 탈퇴일로부터 X일 경과 표시때 사용
- join->end_date : X일 이후부터 가입 가능 표시때 사용

CASE 2 (기가입 회원 체크) :
- 본인인증하여도 기가입여부가 나오면 아예 신규가입이 불가능합니다.
- is_joined : true
- join->available : false
- join->id : 가입한 member_no
- join->name : 가입한 ID
- join->type : 가입경로 관련 정보

CASE 3 (정상가입 가능)
- is_joined : false
- join->available : true

CASE 4 (프로필 정상 편집 가능, refer 보내는 케이스)
- 프로필 편집시 자기 휴대폰 번호를 바꾸려는 케이스
- is_joined : true
- is_same_user : true
또는
- is_joined : false"
 * ```
 * @author gon (leeyg@brandi.co.kr)
 * @since 1/4/21.
 **/

@Serializable
data class SMSVerifyResponse(
    @SerialName( "data")
    val data: VerifyData,
    @SerialName( "meta")
    override val meta: Meta?,
) : Response()

@Serializable
data class VerifyData(
    /**
     * 기가입 여부 체크
     */
    @SerialName( "is_joined")
    val isJoined: Boolean = false,
    /**
     * 로그인한 유저와 본인인증하여 조회되는 회원번호가 서로 같은지
     */
    @SerialName( "is_same_user")
    val isSameUser: Boolean?,
    /**
     * 가입 아이디
     */
    @SerialName( "name")
    val name: String?,
    /**
     * 실명 인증 한 이름
     */
    @SerialName( "certified_name")
    val certifiedName: String?,
    /**
     * 가입경로
     */
    @SerialName( "type")
    val type: String?,
    /**
     * 가입 관련 정보
     */
    @SerialName( "join")
    val join: JoinResult?,
)

@Serializable
data class JoinResult(
    /**
     * 가입가능여부
     */
    @SerialName( "available")
    val available: Boolean,
    /**
     * 가입 가능 날짜
     */
    @SerialName( "available_date")
    val availableDate: String?,
    @SerialName( "brandi_token")
    val brandiToken: String?,
    /**
     * 탈퇴일로부터 경과일수
     */
    @SerialName( "start_date")
    val startDate: Int,
    /**
     * 가입가능한 일수
     */
    @SerialName( "end_date")
    val endDate: Int,
    /**
     * 가입된 계정의 MEMBER_NO
     */
    @SerialName( "id")
    val id: Int,
    /**
     * 가입된 계정의 마스크된 ID
     */
    @SerialName( "name")
    val name: String,
    /**
     * 가입된 계정의 ID
     */
    @SerialName( "nickname")
    val nickname: String?,
    /**
     * 가입경로 정보
     */
    @SerialName( "type")
    val type: JoinType?,
    /**
     * 타서비스 사용 중인지
     */
    @SerialName( "is_service")
    val isService: Boolean?,
)

@Serializable
data class JoinType(
    /**
     * 가입경로 아이디
     */
    @SerialName( "id")
    val id: String,
    /**
     * 가입경로명 (email, google, naver 등)
     */
    @SerialName( "name")
    val name: String,
    /**
     * 가입경로명(영어)
     */
    @SerialName( "en_name")
    val enName: String,
)
