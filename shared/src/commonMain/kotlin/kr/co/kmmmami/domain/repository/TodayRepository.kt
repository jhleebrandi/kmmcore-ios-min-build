package kr.co.kmmmami.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.domain.model.response.MainListResponse

interface TodayRepository {
    suspend fun getToday(
        token: String
    ): Flow<ResultData<MainListResponse>>
}
