package kr.co.kmmmami.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.co.kmmmami.core_data.base.safeApiCallFlow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.data.networking.api.HomeTodayApi
import kr.co.kmmmami.data.utils.QueryMapKey.VERSION
import kr.co.kmmmami.domain.model.response.MainListResponse
import kr.co.kmmmami.domain.repository.TodayRepository

class TodayRepositoryImpl(private val homeTodayApi: HomeTodayApi) : TodayRepository {

    override suspend fun getToday(token: String): Flow<ResultData<MainListResponse>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                this[VERSION] = "204"
            }

            emit(
                safeApiCallFlow {
                    homeTodayApi.getMain(
                        token = token,
                        options = queryMap
                    )
                }
            )
        }
    }
}
