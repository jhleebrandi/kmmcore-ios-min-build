package kr.co.kmmmami.core_data

import kr.co.kmmmami.util.createPlatformLogger

/**
 * Created by jangsc@brandi.co.kr on 12/22/20
 */

object FindErrorCode {
    private val logger = createPlatformLogger("FindErrorCode")

    const val ERROR_MAINTENANCE_EXCEPTION = "ERROR_MAINTENANCE_EXCEPTION"
    private const val ERROR_MAINTENANCE = 503
    private const val ERROR_AUTH_KEY_EXPIRE = 401

    /**
     * 타 계정 멤버
     */
    private const val ERROR_ANOTHER_SERVICE_MEMBER = 4016

    /**
     * 부분 탈퇴
     */
    const val ERROR_PARTLY_UNREGISTERED = 4020

    const val ERROR_DENIY_SIGN_UP = 4025

    private const val ERROR_ORDER_QUANTITY_EXCEED = 7049
    private const val ERROR_ORDER_QUANTITY_LACK = 7050
    private const val ERROR_NO_REQUIRED_OPTION = 7032

    fun isAuthKeyExpire(code: Int): Boolean {
        if (code == ERROR_AUTH_KEY_EXPIRE) {
            logger.w("키 만료")
            return true
        }
        return false
    }

    fun isMaintenance(code: Int): Boolean {
        if (code == ERROR_MAINTENANCE) {
            logger.w("서버 점검")
            return true
        }
        return false
    }

    fun isAnotherServiceMember(code: Int): Boolean {
        if (code == ERROR_ANOTHER_SERVICE_MEMBER || code == ERROR_PARTLY_UNREGISTERED) {
            logger.w("다른 서비스 가입자")
            return true
        }
        return false
    }

    fun isPartlyUnregisteredMember(code: Int): Boolean {
        if (code == ERROR_PARTLY_UNREGISTERED) {
            logger.w("부분 탈퇴")
            return true
        }
        return false
    }

    fun isOrderFail(code: Int): Boolean {
        if (code in 2001..3999 || code == ERROR_NO_REQUIRED_OPTION ||
            code == ERROR_ORDER_QUANTITY_EXCEED || code == ERROR_ORDER_QUANTITY_LACK
        ) {
            logger.w("주문 실패")
            return true
        }
        return false
    }

    // trandi에서는 error message를 api에 포함해서 줌
    fun getErrorResponse(code: Int, message: String? = null): String {
        var errorMessage: String? = null
//        if (code == -2) {
//            errorMessage = "예상치 못 한 오류가 발생했습니다.\n일시적인 현상이거나 네트워크 문제일 수 있으니, 잠시 후 다시 시도해 주세요."
//        } else if (code == -1) {
//            errorMessage = "Receiver Error -1"
//        } else if (code == 0) {
//            errorMessage = "인터넷 연결 상태를 확인하고\n다시 시도해 주세요."
//        } else if (code == 2) {
//            errorMessage = "원활한 서비스 이용을 위해\n네트워크 연결을 확인해주세요."
//        } else if (code == 503) {
//            errorMessage = "서버 점검 중입니다.\n잠시 후 재시도 해주세요."
//        } else if (code == 404) {
//            errorMessage = "찾을 수 없는 페이지\n삭제된 페이지 또는 잘못된 접근입니다.\n불편을 드려 죄송합니다."
//        } else if (code in 400..499) {
//            errorMessage = "잘못된 요청입니다.\n잠시 후 재시도 해주세요."
//        } else if (code in 500..599) {
//            errorMessage = "서버 응답 오류입니다.\n잠시 후 재시도 해주세요."
//        } else if (code == 1001) {
//            errorMessage = "필수 요청값이 누락되었습니다"
//        } else if (code == 1002) {
//            errorMessage = "실행 권한이 없습니다"
//        } else if (code == 1003) {
//            errorMessage = "중복 요청입니다."
//        } else if (code == 1004) {
//            errorMessage = "비회원은 실행 권한이 없습니다."
//        } else if (code == 1005) {
//            errorMessage = "재입고알림신청은 주문하기 페이지에서 실명인증 진행 후 이용 가능합니다."
//        } else if (code == 1008) {
//            errorMessage = "올바르지 않는 데이터 형식으로 요청"
//        } else if (code == 2001) {
//            errorMessage = "존재하지 않는 상품입니다"
//        } else if (code == 2002) {
//            errorMessage = "현재 판매되지 않는 상품입니다"
//        } else if (code == 2003) {
//            errorMessage = "품절된 상품이 있어 주문이 불가합니다."
//        } else if (code == 2004) {
//            errorMessage = "구매 불가능한 상품이 포함되어 있습니다"
//        } else if (code == 2005) {
//            errorMessage = "구매 가능 수량을 충족하지 못한 상품이 있습니다"
//        } else if (code == 2006) {
//            errorMessage = "재고 변경으로 재입고 알림 신청이 불가능합니다"
//        } else if (code == 3001) {
//            errorMessage = "가격정보가 일치하지 않습니다"
//        } else if (code == 3002) {
//            errorMessage = "포인트 조회에 실패했습니다"
//        } else if (code == 3003) {
//            errorMessage = "사용 가능한 포인트를 초과했습니다"
//        } else if (code == 3004) {
//            errorMessage = "사용 포인트 비율 초과"
//        } else if (code == 3005) {
//            errorMessage = "쿠폰사용 최소주문금액이 미달입니다."
//        } else if (code == 3006) {
//            errorMessage = "쿠폰사용 불가 상품입니다."
//        } else if (code == 3007) {
//            errorMessage = "쿠폰 할인금액 불일치"
//        } else if (code == 3008) {
//            errorMessage = "상품 가격이 변경되어 예상 결제 금액과 일치하지 않습니다. 새로고침 후에 다시 진행해 주세요."
//        } else if (code == 3009) {
//            errorMessage = "존재하지 않는 입력 계좌입니다."
//        } else if (code == 3010) {
//            errorMessage = "배송지 입력 가능갯수는 최대 5개입니다."
//        } else if (code == 3011) {
//            errorMessage = "기본 배송지를 일반 배송지로 수정 불가"
//        } else if (code == 3012) {
//            errorMessage = "최초 등록 배송지가 기본 배송지가 아님"
//        } else if (code == 3013) {
//            errorMessage = "배송지정보 1개 있을 경우 삭제 불가"
//        } else if (code == 3014) {
//            errorMessage = "회원의 배송지가 아니거나 유효하지 않은 배송지 정보"
//        } else if (code == 3015) {
//            errorMessage = "유효하지 않은 배송지 정보입니다.\n배송지를 수정해주세요"
//        } else if (code == 3016) {
//            errorMessage = "하루배송 서비스 이용 불가 지역"
//        } else if (code == 3017) {
//            errorMessage = "하루배송 서비스 마감으로 이용 불가"
//        } else if (code == 3018) {
//            errorMessage = "하루배송 서비스 이용 불가 (비회원 또는 잘못된 접근으로 인한 조건 미충족)"
//        } else if (code == 3019) {
//            errorMessage = "하루배송 상품 포함되었을 경우 무통장입금 결제 불가"
//        } else if (code == 4001) {
//            errorMessage = "닉네임 형식 오류"
//        } else if (code == 4002) {
//            errorMessage = "이메일 형식이 올바르지 않습니다"
//        } else if (code == 4003) {
//            errorMessage = "중복 닉네임"
//        } else if (code == 4004) {
//            errorMessage = "가입된 SNS 회원"
//        } else if (code == 4005) {
//            errorMessage = "존재하지 않는 이메일입니다."
//        } else if (code == 4006) {
//            errorMessage = "가입된 SNS 회원입니다."
//        } else if (code == 4007) {
//            errorMessage = "중복된 이메일입니다."
//        } else if (code == 4008) {
//            errorMessage = "유효하지 않은 본인인증 번호입니다."
//        } else if (code == 4009) {
//            errorMessage = "중복 본인인증 CI 번호입니다."
//        } else if (code == 4010) {
//            errorMessage = "요청 주신 정보와 동일한 회원 정보가 없습니다. 다시 한번 확인해 주세요." // 본인인증 정보가 없습니다.";
//        } else if (code == 4011) {
//            errorMessage = "기존 비밀번호를 다시 확인해 주세요."
//        } else if (code == 4012) {
//            errorMessage = "잘못된 비밀번호 형식입니다."
//        } else if (code == 4013) {
//            errorMessage = "처리할 수 없는 회원 상태입니다."
//        } else if (code == 4014) {
//            errorMessage = "진행중인 주문건이 있어 탈퇴 불가 상태입니다."
//        } else if (code == 4015) {
//            errorMessage = "탈퇴 후 한달간 재가입 불가 상태입니다."
//        } else if (code == 4016) {
//            errorMessage = "실명인증에 실패했습니다. 고객센터로 문의 부탁 드립니다."
//        } else if (code == 4018) {
//            errorMessage = "서비스 이용약관, 개인정보수집이용 동의 필요합니다." // "브랜디 이용약관, 개인정보수집이용 동의 필요합니다."
//        } else if (code == 4019) {
//            errorMessage = "야간 혜택 알림 수신 동의 시 이벤트/마케팅 수신 동의 필수입니다."
//        } else if (code == 4020) {
//            errorMessage = "탈퇴 후 한 달간 재가입 불가 상태입니다."
//        } else if (code == 4021) {
//            errorMessage = "이메일 계정 전환 필요"
//        } else if (code == 4022) {
//            errorMessage = "비밀번호를 다시 확인해주세요"
//        } else if (code == 4023) {
//            errorMessage = "동일한 SNS계정으로 이미 가입되어 있어, 해당 계정에 연동이 불가합니다."
//        } else if (code == 4026) {
//            errorMessage = "카카오 계정 연동이 해제되어 이용이 어렵습니다. 카카오 고객센터로 문의 후 이용해 주세요."
//        } else if (code == 4027) {
//            errorMessage = "만 14세 이상인 사용자만 서비스 이용이 가능합니다."
//        } else if (code == 4028) {
//            errorMessage = "카카오 계정이 사용 중지되었습니다. 카카오 고객센터로 문의 후 이용해 주세요."
//        } else if (code == 5001) {
//            errorMessage = "존재하지 않는 포인트코드입니다"
//        } else if (code == 5002) {
//            errorMessage = "이미 사용된 포인트코드입니다"
//        } else if (code == 5003) {
//            errorMessage = "유효기간이 지난 포인트코드입니다"
//        } else if (code == 5004) {
//            errorMessage = "포인트코드 제한 수량이 초과하였습니다"
//        } else if (code == 5005) {
//            errorMessage = "이미 다운로드한 포인트코드입니다"
//        } else if (code == 6001) {
//            errorMessage = "유효하지 않은 쿠폰입니다."
//        } else if (code == 6002) {
//            errorMessage = "이미 사용된 쿠폰입니다."
//        } else if (code == 6003) {
//            errorMessage = "유효기간이 지난 쿠폰입니다."
//        } else if (code == 6004) {
//            errorMessage = "발급 가능한 쿠폰 수량을 초과했습니다."
//        } else if (code == 6005) {
//            errorMessage = "이미 등록된 쿠폰입니다."
//        } else if (code == 6009) {
//            errorMessage = "유효하지 않은 쿠폰입니다. 고객센터로 문의 부탁드립니다."
//        } else if (code == 7001) {
//            errorMessage = "존재하지 않는 주문정보입니다."
//        } else if (code == 7002) {
//            errorMessage = "요청 회원의 주문건이 아닙니다."
//        } else if (code == 7003) {
//            errorMessage = "존재하지 않는 체크아웃정보입니다."
//        } else if (code == 7004) {
//            errorMessage = "배송준비 날짜 정보 없습니다."
//        } else if (code == 7005) {
//            errorMessage = "배송준비상태 변경 후 3영업일까지 취소를 진행할 수 없습니다."
//        } else if (code == 7006) {
//            errorMessage = "현재 주문상태에서는 취소를 진행할 수 없습니다."
//        } else if (code == 7007) {
//            errorMessage = "현재 주문상태에서는 환불을 진행할 수 없습니다."
//        } else if (code == 7008) {
//            errorMessage = "금액 계산 오류입니다."
//        } else if (code == 7009) {
//            errorMessage = "주문취소 유형 없습니다."
//        } else if (code == 7010) {
//            errorMessage = "주문취소 정보 입력 오류입니다."
//        } else if (code == 7011) {
//            errorMessage = "주문상세 주문취소 정보 갱신 오류입니다."
//        } else if (code == 7012) {
//            errorMessage = "취소 정보 입력 오류입니다."
//        } else if (code == 7013) {
//            errorMessage = "올바르지 않은 은행코드입니다."
//        } else if (code == 7014) {
//            errorMessage = "계좌정보 입력 오류입니다."
//        } else if (code == 7015) {
//            errorMessage = "클레임 정보 입력 오류입니다."
//        } else if (code == 7016) {
//            errorMessage = "회원 포인트 환급 오류입니다."
//        } else if (code == 7017) {
//            errorMessage = "결제 수단에 맞지 않는 포인트 환급액입니다."
//        } else if (code == 7018) {
//            errorMessage = "결제 수단에 맞지 않는 포인트 환급액입니다."
//        } else if (code == 7019) {
//            errorMessage = "주문상세 변경이력 입력 오류입니다."
//        } else if (code == 7020) {
//            errorMessage = "주문상세 주문상태 수정 오류입니다."
//        } else if (code == 7021) {
//            errorMessage = "존재하지 않는 PG 승인결과 정보입니다."
//        } else if (code == 7022) {
//            errorMessage = "주문 취소 금액이 결제금액과 일치하지 않습니다."
//        } else if (code == 7023) {
//            errorMessage = "PG 주문 취소 처리 실패입니다."
//        } else if (code == 7024) {
//            errorMessage = "PG 주문 부분취소 처리 실패입니다."
//        } else if (code == 7025) {
//            errorMessage = "서비스 노출정보 생성 실패입니다."
//        } else if (code == 7026) {
//            errorMessage = "지원하지 않는 취소/환불정보 조회 타입입니다."
//        } else if (code == 7027) {
//            errorMessage = "환불 정보 입력 오류입니다."
//        } else if (code == 7028) {
//            errorMessage = "올바르지 않은 환불사유 코드입니다."
//        } else if (code == 7029) {
//            errorMessage = "현재 주문상태에서는 요청을 진행할 수 없습니다."
//        } else if (code == 7030) {
//            errorMessage = "주문 진행중인 선택형 상품이 있어 요청을 진행할 수 없습니다."
//        } else if (code == 7031) {
//            errorMessage = "선택형 상품 우선 철회 불가합니다."
//        } else if (code == 7032) {
//            errorMessage = "필수옵션상품 선택되지 않았습니다."
//        } else if (code == 7033) {
//            errorMessage = "필수옵션상품 삭제가 불가합니다."
//        } else if (code == 7037) {
//            errorMessage = "비회원 주문 시 쿠폰, 포인트 사용 불가합니다."
//        } else if (code == 7038) {
//            errorMessage = "일치하는 주문 정보가 없습니다.\n정보를 다시 확인해주세요."
//        } else if (code == 7039) {
//            errorMessage = "유효하지 않은 휴대폰 인증결과 코드입니다."
//        } else if (code == 7043) {
//            errorMessage = "동일 옵션의 최대 구매 수량을 초과하였습니다\n" +
//                "장바구니를 확인해주세요"
//        } else if (code == 7046) {
//            // 장바구니에 품절 상태인 상품이 존재하지 않음.
//            errorMessage = "품절상품이 없습니다."
//        } else if (code == 7047) {
//            errorMessage = if (message.isNullOrEmpty()) {
//                "첫구매 혜택 쿠폰을 사용한 상품을\n먼저 취소해주세요.\n해당 상품이 발송되었을 경우\n고객센터로 문의부탁드립니다."
//            } else {
//                message
//            }
//        } else if (code == 7048 || code == 7049 || code == 7050) {
//            errorMessage = message ?: "알 수 없는 오류입니다.\n재시도 해주세요. $code"
//        } else if (code == 8001) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8002) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8003) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8004) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8005) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8006) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8007) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8008) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8009) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8010) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8011) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8012) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8013) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8014) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8015) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8016) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8017) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8018) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8019) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8020) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8021) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8022) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8023) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8024) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8025) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8026) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8027) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8028) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8029) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8030) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8031) {
//            errorMessage = "만 14세 미만 회원은 가입이 불가합니다."
//        } else if (code == 8032) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8033) {
//            errorMessage = "인증번호 3회 불일치입니다."
//        } else if (code == 8034) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 다시 한번 시도해주세요. $code"
//        } else if (code == 8035) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 오류가 계속 발생하는 경우 마미 고객센터로 문의전화 주세요."
//        } else if (code == 8036) {
//            errorMessage = "휴대폰 본인인증에 오류가 발생하였습니다. 오류가 계속 발생하는 경우 마미 고객센터로 문의전화 주세요."
//        } else if (code == 8037) {
//            errorMessage = "휴대폰 인증 요청 실패"
//        } else if (code == 9001) {
//            errorMessage = "수정은 포인트 지급 한달 후 가능합니다. 양해 부탁 드립니다."
//        } else if (code == 9002) {
//            errorMessage = "삭제는 포인트 지급 한달 후 가능합니다. 양해 부탁 드립니다."
//        } else if (code == 9003) {
//            errorMessage = "리뷰가 삭제되었거나 유효하지 않아 댓글을 작성할 수 없습니다."
//        } else if (code == 9004) {
//            errorMessage = "댓글이 삭제되었거나 유효하지 않아 답글을 작성할 수 없습니다."
//        } else if (code == 9005) {
//            errorMessage = "리뷰 내용, 댓글 최대 글자수 500자를 초과할 수 없습니다."
//        } else if (code == 9006) {
//            errorMessage = "리뷰 내용, 댓글 최대 글자수 500자를 초과할 수 없습니다."
//        } else if (code == 1006) {
//            errorMessage = "미인증회원 이용 불가."
//        } else {
//            errorMessage = "알 수 없는 오류입니다.\n재시도 해주세요. $code"
//        }
        // null
        // 80XX
        // 70xx
        // custom 에러 코드
        errorMessage = "알 수 없는 오류입니다.\n재시도 해주세요. $code"
        logger.w("$code $errorMessage")
        return errorMessage
    }

    fun getAuthAccountErrorMessage(): String {
        return "아이디와 비밀번호를 다시 확인해주세요"
    }
}
