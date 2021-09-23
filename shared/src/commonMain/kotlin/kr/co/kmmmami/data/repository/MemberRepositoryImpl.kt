package kr.co.kmmmami.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.*
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.core_data.base.safeApiCallFlow
import kr.co.kmmmami.core_data.model.RootData
import kr.co.kmmmami.core_data.social.SOCIAL_TYPE
import kr.co.kmmmami.data.networking.api.LoginAPI
import kr.co.kmmmami.data.networking.api.LoginCommerceAPI
import kr.co.kmmmami.data.networking.api.SearchAPI
import kr.co.kmmmami.data.networking.api.SmsAPI
import kr.co.kmmmami.data.utils.QueryMapKey.KAKAO_SNS_COMMON_ID
import kr.co.kmmmami.data.utils.QueryMapKey.KAKAO_SNS_COMMON_ID_TYPE
import kr.co.kmmmami.data.utils.QueryMapKey.KAKAO_SNS_SERVICE_ID
import kr.co.kmmmami.data.utils.QueryMapKey.SNS_SERVICE_ID
import kr.co.kmmmami.data.utils.QueryMapKey.SNS_SERVICE_TYPE
import kr.co.kmmmami.data.utils.QueryMapKey.TYPE
import kr.co.kmmmami.domain.model.request.KidsRequest
import kr.co.kmmmami.domain.model.request.SignUpRequest
import kr.co.kmmmami.domain.model.request.UserSelfRequest
import kr.co.kmmmami.domain.model.request.VERIFICATION_TYPE
import kr.co.kmmmami.domain.model.response.*
import kr.co.kmmmami.domain.repository.MemberRepository

class MemberRepositoryImpl(
    private val loginAPI: LoginAPI,
    private val smsAPI: SmsAPI,
    private val loginCommerceAPI: LoginCommerceAPI,
    private val searchAPI: SearchAPI,
) : MemberRepository {

    override suspend fun getUsersSelfSellers(
        token: String,
    ): Flow<ResultData<BookMarkListResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginCommerceAPI.getUsersSelfSellers(
                        token
                    )
                }
            )
        }
    }

    override suspend fun getUsersSelfDevices(
        token: String,
    ): Flow<ResultData<GcmIdListResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.getUsersSelfDevices(
                        token
                    )
                }
            )
        }
    }

    override suspend fun getUsersSelfProductNos(
        token: String,
    ): Flow<ResultData<BookMarkListResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginCommerceAPI.getUsersSelfProductNos(
                        token
                    )
                }
            )
        }
    }

    override suspend fun getUsersSelf(
        token: String,
    ): Flow<ResultData<MyProfileResponse>> {
        return flow {
            emit(safeApiCallFlow { loginAPI.getUsersSelf(token) })
        }
    }

    override suspend fun getUsersSelfMeta(
        token: String,
    ): Flow<ResultData<UserMetaResponse>> {
        return flow {
            emit(
                safeApiCallFlow { searchAPI.getUsersSelfMeta(token) }
            )
        }
    }

    override suspend fun postUserLogin(
        token: String,
        bodyData: HashMap<String, String>,
    ): Flow<ResultData<AuthAccountResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.postUserLogin(
                        token,
                        bodyData
                    )
                }
            )
        }
    }

    override suspend fun getUserSnsBySocial(
        token: String,
        sns_type: String,
        options: Map<String, String>,
    ): Flow<ResultData<AuthAccountResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.getUserSnsBySocial(token, sns_type, options)
                }
            )
        }
    }

    override suspend fun postUserSnsBySocial(
        token: String,
        sns_type: String,
        map: Map<String, String>,
    ): Flow<ResultData<AuthAccountResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.postUserSnsBySocial(token, sns_type, map)
                }
            )
        }
    }

    override suspend fun postMemberPush(
        token: String,
        pushType: String,
    ): Flow<ResultData<UserPushResponse>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                this[TYPE] = pushType
            }

            emit(
                safeApiCallFlow {
                    loginAPI.postMemberPush(
                        token,
                        queryMap
                    )
                }
            )
        }
    }

    override suspend fun deleteMemberPush(
        token: String,
        pushType: String,
    ): Flow<ResultData<UserPushResponse>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                this[TYPE] = pushType
            }

            emit(
                safeApiCallFlow {
                    loginAPI.deleteMemberPush(
                        token,
                        queryMap
                    )
                }
            )
        }
    }

    override suspend fun postDeleteMember(
        token: String,
        selectReasonList: ArrayList<Int>,
        verificationResultId: String?,
    ): Flow<ResultData<RootData>> {
        return flow {
            val jsonObject = buildJsonObject {
                putJsonArray("choose_no_list") {
                    for (i in selectReasonList.indices) {
                        add(selectReasonList[i])
                    }
                }
                if (verificationResultId != null) {
                    put("verification_result_id", verificationResultId)
                }
            }

            emit(
                safeApiCallFlow {
                    loginAPI.postDeleteMember(
                        token,
                        jsonObject
                    )
                }
            )
        }
    }

    override suspend fun putUsersSelfPassword(
        token: String,
        currentPassword: CharArray,
        newPassword: CharArray,
    ): Flow<ResultData<ProfilePwModifyResponse>> {
        return flow {
            val jsonObject = buildJsonObject {
                put("password", currentPassword.toString())
                put("change_password", newPassword.toString())
            }

            emit(
                safeApiCallFlow {
                    loginAPI.putUsersSelfPassword(
                        token,
                        jsonObject
                    )
                }
            )
        }
    }

    override suspend fun postUsersModify(
        token: String,
        data: EditableProfileData,
        fileByteArray: ByteArray?,
        fileName: String,
    ): Flow<ResultData<ProfileModifyResponse>> {
        val verificationType = data.verificationType

        val jsonObject = buildJsonObject {
            put("name", data.name)
            put("gender", data.gender)
            put("birth_date", data.birthDate)
            put("weight", data.weight)
            put("height", data.height)
            put("email", data.email)
            put("telephone", data.telephone)
            if (data.updateName != null) {
                put("update_name", data.updateName)
            }
            if (verificationType == VERIFICATION_TYPE.REAL_NAME_CERTIFICATION.ordinal || verificationType == VERIFICATION_TYPE.TELEPHONE_CERTIFICATION.ordinal
            ) {
                put("verification_type", data.verificationType)
                if (verificationType == VERIFICATION_TYPE.REAL_NAME_CERTIFICATION.ordinal) {
                    put("verification_result_id", data.typeValue)
                } else {
                    put("certification_id", data.typeValue)
                }
            }
        }

        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.postUsersModify(
                        token,
                        jsonObject,
                        fileByteArray,
                        fileName
                    )
                }
            )
        }
    }

    override suspend fun getSmsCertify(
        token: String,
        phoneNumber: String,
    ): Flow<ResultData<SMSVerifyResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    smsAPI.getSmsCertify(token, phoneNumber)
                }
            )
        }
    }

    override suspend fun verifySmsCertify(
        token: String,
        phoneNumber: String,
        certificationKey: String,
    ): Flow<ResultData<VerifyCodeResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    smsAPI.verifySmsCertify(token, phoneNumber, certificationKey)
                }
            )
        }
    }

    override suspend fun postUsersFindId(
        token: String,
        telephone: String,
        certificationCode: String,
    ): Flow<ResultData<FindUserResponse>> {
        return flow {
            val jsonObject = buildJsonObject {
                put("telephone", telephone)
                put("certification_id", certificationCode)
            }

            emit(
                safeApiCallFlow {
                    loginAPI.postFindId(token, jsonObject)
                }
            )
        }
    }

    override suspend fun getEmailCertify(token: String, email: String): Flow<ResultData<RootData>> {
        return flow {
            emit(
                safeApiCallFlow {
                    smsAPI.getEmailCertify(token, email)
                }
            )
        }
    }

    override suspend fun getVerifyEmailCode(
        token: String,
        email: String,
        certCode: String,
    ): Flow<ResultData<VerifyCodeResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    smsAPI.getVerifyEmailCode(token, email, certCode)
                }
            )
        }
    }

    override suspend fun postUsersFindIdByEmail(
        token: String,
        email: String,
        certCode: String,
    ): Flow<ResultData<FindUserResponse>> {
        return flow {
            val jsonObject = buildJsonObject {
                put("email", email)
                put("certification_id", certCode)
            }

            emit(
                safeApiCallFlow {
                    loginAPI.postFindIdByEmail(token, jsonObject)
                }
            )
        }
    }

    override suspend fun postUsersFindIdVerification(
        token: String,
        verificationResultId: String,
    ): Flow<ResultData<FindUserResponse>> {
        return flow {
            val jsonObject = buildJsonObject {
                put("verification_result_id", verificationResultId)
            }

            emit(
                safeApiCallFlow {
                    loginAPI.postUsersFindIdVerification(token, jsonObject)
                }
            )
        }
    }

    override suspend fun postUsersFindPassword(
        token: String,
        userId: String,
        telephone: String,
        certificationCode: String,
    ): Flow<ResultData<FindUserResponse>> {
        return flow {
            val jsonObject = buildJsonObject {
                put("name", userId)
                put("certification_id", certificationCode)
                put("telephone", telephone)
            }

            emit(
                safeApiCallFlow {
                    loginAPI.postUsersFindPassword(token, jsonObject)
                }
            )
        }
    }

    override suspend fun postUsersFindPasswordVerification(
        token: String,
        name: String,
        isUpdate: Boolean,
        verificationResultId: String,
    ): Flow<ResultData<FindUserResponse>> {
        return flow {
            val jsonObject = buildJsonObject {
                put("name", name)
                put("is_update", isUpdate)
                put("verification_result_id", verificationResultId)
            }

            emit(
                safeApiCallFlow {
                    loginAPI.postUsersFindPasswordVerification(token, jsonObject)
                }
            )
        }
    }

    override suspend fun getMembersNickname(
        token: String,
        nickname: String,
    ): Flow<ResultData<AuthDuplicateResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.getUserNickname(token, nickname)
                }
            )
        }
    }

    override suspend fun getMembersEmail(
        token: String,
        email: String,
    ): Flow<ResultData<AuthDuplicateResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.getUserEmail(token, email)
                }
            )
        }
    }

    override suspend fun getUsersRecommendCode(
        token: String,
        recommendCode: String,
    ): Flow<ResultData<RecommendDuplicateResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.getUsersRecommendCode(token, recommendCode)
                }
            )
        }
    }

    override suspend fun postUsersSignUp(
        token: String,
        signUpRequest: SignUpRequest,
        fileByteArray: ByteArray?,
        fileName: String,
    ): Flow<ResultData<AuthAccountResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.postUsersSignUp(token, signUpRequest, fileByteArray, fileName)
                }
            )
        }
    }

    override suspend fun getKidsInfo(token: String): Flow<ResultData<KidsResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.getKidsInfo(token)
                }
            )
        }
    }

    override suspend fun postKidsInfo(
        token: String,
        isConvert: Boolean,
        request: KidsRequest,
        fileByteArrayList: List<ByteArray>?,
        fileNameList: List<String>,
    ): Flow<ResultData<CompletedPhraseResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.postKidsInfo(token, isConvert, request, fileByteArrayList, fileNameList)
                }
            )
        }
    }

    override suspend fun postUserSelfService(
        token: String,
        userSelfRequest: UserSelfRequest,
    ): Flow<ResultData<CompletedPhraseResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.postUserSelfService(token, userSelfRequest)
                }
            )
        }
    }

    override suspend fun requestVerifyPostedCode(
        token: String,
        verifyCode: String,
        refer: String?,
    ): Flow<ResultData<SMSVerifyResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.verifyPhone(token, verifyCode, refer)
                }
            )
        }
    }

    /**
     * [B20-10차] 핸드폰 인증번호 SMS로 요청
     * 98 회원 인증용(프로필 전화번호변경) 인증 코드 전송
     * @param refer 프로필편집에서 하는 휴대폰 인증의 경우만 보냅니다.
     * 해당 케이스에서는 탈퇴 회원 여부 체크 안합니다."
     */
    override suspend fun postVerifyCode(
        token: String,
        telephone: String,
        refer: String?,
    ): Flow<ResultData<SMSVerifyResponse>> {
        val jsonObject = buildJsonObject {
            put("telephone", telephone)
        }

        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.verifyPhone(token, jsonObject, refer)
                }
            )
        }
    }

    override suspend fun getSNSInfo(
        token: String,
    ): Flow<ResultData<AuthSNSInfoResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.getSNSInfo(token)
                }
            )
        }
    }

    override suspend fun putSNSLinkOn(
        token: String,
        sns_type: String,
        sns_id: String,
        sns_common_id: String?,
        refer: String,
        nickname: String?,
        password: String?,
        sns_common_id_type: String?,
    ): Flow<ResultData<RootData>> {

        val jsonObject = buildJsonObject {
            put("sns_type", sns_type)
            put("sns_id", sns_id)
            put("sns_common_id", sns_common_id)
            put("sns_common_id_type", sns_common_id_type)
            put("refer", refer)
            put("nickname", nickname)
            put("password", password)
        }

        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.putSNSLinkOn(token, jsonObject)
                }
            )
        }
    }

    override suspend fun putSNSLinkOff(
        token: String,
        snsAccountId: String,
    ): Flow<ResultData<RootData>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.putSNSLinkOff(token, snsAccountId)
                }
            )
        }
    }

    override suspend fun getUserSnsBySocial(
        token: String,
        socialType: SOCIAL_TYPE,
        snsServiceType: String?,
        snsServiceId: String?,
        snsName: String,
        snsId: String?,
        kakaoGroupUserToken: String?
    ): Flow<ResultData<AuthAccountResponse>> {
        val queryMap = HashMap<String, String>().apply {
            if (socialType == SOCIAL_TYPE.FACE_BOOK) {
                snsServiceType?.let {
                    this[SNS_SERVICE_TYPE] = it
                }
                snsServiceId?.let {
                    this[SNS_SERVICE_ID] = it
                }
            } else if (socialType == SOCIAL_TYPE.KAKAO_ID) {
                snsId?.let {
                    this[KAKAO_SNS_SERVICE_ID] = it
                }
                kakaoGroupUserToken?.let {
                    this[KAKAO_SNS_COMMON_ID] = it
                    this[KAKAO_SNS_COMMON_ID_TYPE] = "group"
                }
            } else if (socialType == SOCIAL_TYPE.NAVER_ID || socialType == SOCIAL_TYPE.GOOGLE) {
                snsId?.let {
                    this[SNS_SERVICE_ID] = it
                }
            } else if (socialType == SOCIAL_TYPE.APPLE_ID) {
                snsId?.let {
                    this[SNS_SERVICE_ID] = it
                }
            }
        }

        return flow {
            emit(
                safeApiCallFlow {
                    if (socialType == SOCIAL_TYPE.KAKAO_ID) {
                        loginAPI.postUserSnsBySocial(
                            token,
                            snsName,
                            queryMap
                        )
                    } else
                        loginAPI.getUserSnsBySocial(token, snsName, queryMap)
                }
            )
        }
    }

    override suspend fun putUserSelfVerification(
        token: String,
        requestData: JsonObject,
    ): Flow<ResultData<RootData>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginAPI.putUsersSelfVerification(token, requestData)
                }
            )
        }
    }

    override suspend fun putTransformAccount(
        token: String,
        snsAccountId: String,
        memberNo: String,
        password: String,
    ): Flow<ResultData<RootData>> {
        return flow {
            val jsonObject = buildJsonObject {
                put("member_no", memberNo)
                put("password", password)
                put("member_sns_account_no", snsAccountId)
            }

            emit(
                safeApiCallFlow {
                    loginAPI.putTransformAccount(
                        token,
                        jsonObject
                    )
                }
            )
        }
    }

    override suspend fun postTrackerEvent(
        token: String,
        requestData: JsonObject,
    ): Flow<ResultData<RootData>> {
        return flow {
            emit(
                safeApiCallFlow {
                    smsAPI.postTrackerEvent(token, requestData)
                }
            )
        }
    }

    override suspend fun postMembersDeviceFcm(
        token: String,
        pushId: String,
    ): Flow<ResultData<RootData>> {
        return flow {
            val jsonObject = buildJsonObject {
                put("device_code", pushId)
                put("device_type", "G")
            }

            emit(
                safeApiCallFlow {
                    loginAPI.postMembersDevice(token, jsonObject)
                }
            )
        }
    }
}
