package kr.co.kmmmami.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.json.JsonObject
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.core_data.model.RootData
import kr.co.kmmmami.core_data.social.SOCIAL_TYPE
import kr.co.kmmmami.domain.model.request.KidsRequest
import kr.co.kmmmami.domain.model.request.SignUpRequest
import kr.co.kmmmami.domain.model.request.UserSelfRequest
import kr.co.kmmmami.domain.model.response.*

interface MemberRepository {
    suspend fun getUsersSelfSellers(
        token: String,
    ): Flow<ResultData<BookMarkListResponse>>

    suspend fun getUsersSelfDevices(
        token: String,
    ): Flow<ResultData<GcmIdListResponse>>

    suspend fun getUsersSelfProductNos(
        token: String,
    ): Flow<ResultData<BookMarkListResponse>>

    suspend fun getUsersSelf(
        token: String,
    ): Flow<ResultData<MyProfileResponse>>

    suspend fun getUsersSelfMeta(
        token: String,
    ): Flow<ResultData<UserMetaResponse>>

    suspend fun postUserLogin(
        token: String,
        bodyData: HashMap<String, String>,
    ): Flow<ResultData<AuthAccountResponse>>

    suspend fun getUserSnsBySocial(
        token: String,
        sns_type: String,
        options: Map<String, String>,
    ): Flow<ResultData<AuthAccountResponse>>

    suspend fun postUserSnsBySocial(
        token: String,
        sns_type: String,
        map: Map<String, String>,
    ): Flow<ResultData<AuthAccountResponse>>

    suspend fun postMemberPush(
        token: String,
        pushType: String,
    ): Flow<ResultData<UserPushResponse>>

    suspend fun deleteMemberPush(
        token: String,
        pushType: String,
    ): Flow<ResultData<UserPushResponse>>

    suspend fun postDeleteMember(
        token: String,
        selectReasonList: ArrayList<Int>,
        verificationResultId: String?,
    ): Flow<ResultData<RootData>>

    suspend fun putUsersSelfPassword(
        token: String,
        currentPassword: CharArray,
        newPassword: CharArray,
    ): Flow<ResultData<ProfilePwModifyResponse>>

    suspend fun postUsersModify(
        token: String,
        data: EditableProfileData,
        fileByteArray: ByteArray?,
        fileName: String,
    ): Flow<ResultData<ProfileModifyResponse>>

    suspend fun getSmsCertify(
        token: String,
        phoneNumber: String,
    ): Flow<ResultData<SMSVerifyResponse>>

    suspend fun verifySmsCertify(
        token: String,
        phoneNumber: String,
        certificationKey: String,
    ): Flow<ResultData<VerifyCodeResponse>>

    suspend fun postUsersFindId(
        token: String,
        telephone: String,
        certificationCode: String,
    ): Flow<ResultData<FindUserResponse>>

    suspend fun getEmailCertify(
        token: String,
        email: String,
    ): Flow<ResultData<RootData>>

    suspend fun getVerifyEmailCode(
        token: String,
        email: String,
        certCode: String,
    ): Flow<ResultData<VerifyCodeResponse>>

    suspend fun postUsersFindIdByEmail(
        token: String,
        email: String,
        certCode: String,
    ): Flow<ResultData<FindUserResponse>>

    suspend fun postUsersFindIdVerification(
        token: String,
        verificationResultId: String,
    ): Flow<ResultData<FindUserResponse>>

    suspend fun postUsersFindPassword(
        token: String,
        userId: String,
        telephone: String,
        certificationCode: String,
    ): Flow<ResultData<FindUserResponse>>

    suspend fun postUsersFindPasswordVerification(
        token: String,
        name: String,
        isUpdate: Boolean,
        verificationResultId: String,
    ): Flow<ResultData<FindUserResponse>>

    suspend fun getMembersNickname(
        token: String,
        nickname: String,
    ): Flow<ResultData<AuthDuplicateResponse>>

    suspend fun getMembersEmail(
        token: String,
        email: String,
    ): Flow<ResultData<AuthDuplicateResponse>>

    suspend fun getUsersRecommendCode(
        token: String,
        recommendCode: String,
    ): Flow<ResultData<RecommendDuplicateResponse>>

    suspend fun postUsersSignUp(
        token: String,
        signUpRequest: SignUpRequest,
        fileByteArray: ByteArray?,
        fileName: String,
    ): Flow<ResultData<AuthAccountResponse>>

    suspend fun getKidsInfo(
        token: String,
    ): Flow<ResultData<KidsResponse>>

    suspend fun postKidsInfo(
        token: String,
        isConvert: Boolean,
        request: KidsRequest,
        fileByteArrayList: List<ByteArray>?,
        fileNameList: List<String>,
    ): Flow<ResultData<CompletedPhraseResponse>>

    suspend fun postUserSelfService(
        token: String,
        userSelfRequest: UserSelfRequest,
    ): Flow<ResultData<CompletedPhraseResponse>>

    suspend fun requestVerifyPostedCode(
        token: String,
        verifyCode: String,
        refer: String? = null,
    ): Flow<ResultData<SMSVerifyResponse>>

    suspend fun postVerifyCode(
        token: String,
        telephone: String,
        refer: String? = null,
    ): Flow<ResultData<SMSVerifyResponse>>

    suspend fun getSNSInfo(
        token: String,
    ): Flow<ResultData<AuthSNSInfoResponse>>

    suspend fun putSNSLinkOn(
        token: String,
        sns_type: String,
        sns_id: String,
        sns_common_id: String?,
        refer: String,
        nickname: String?,
        password: String?,
        sns_common_id_type: String?,
    ): Flow<ResultData<RootData>>

    suspend fun putSNSLinkOff(
        token: String,
        snsAccountId: String,
    ): Flow<ResultData<RootData>>

    suspend fun getUserSnsBySocial(
        token: String,
        socialType: SOCIAL_TYPE,
        snsServiceType: String?,
        snsServiceId: String?,
        snsName: String,
        snsId: String?,
        kakaoGroupUserToken: String?,
    ): Flow<ResultData<AuthAccountResponse>>

    suspend fun putUserSelfVerification(
        token: String,
        requestData: JsonObject,
    ): Flow<ResultData<RootData>>

    suspend fun putTransformAccount(
        token: String,
        snsAccountId: String,
        memberNo: String,
        password: String,
    ): Flow<ResultData<RootData>>

    suspend fun postTrackerEvent(
        token: String,
        requestData: JsonObject,
    ): Flow<ResultData<RootData>>

    suspend fun postMembersDeviceFcm(
        token: String,
        pushId: String,
    ): Flow<ResultData<RootData>>
}
