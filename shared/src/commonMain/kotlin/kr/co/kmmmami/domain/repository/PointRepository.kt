package kr.co.kmmmami.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.domain.model.response.PointDownloadResponse
import kr.co.kmmmami.domain.model.response.PointResponse
import kr.co.kmmmami.domain.model.response.UserSelfPointResponse

interface PointRepository {
    suspend fun getPoint(
        token: String
    ): Flow<ResultData<PointResponse>>

    suspend fun getSelfPoints(
        lt: String,
        token: String
    ): Flow<ResultData<UserSelfPointResponse>>

    suspend fun postCouponsPoint(
        token: String,
        code: String
    ): Flow<ResultData<PointDownloadResponse>>
}
