package kr.co.kmmmami.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.core_data.base.safeApiCallFlow
import kr.co.kmmmami.data.networking.api.MyPointApi
import kr.co.kmmmami.data.utils.QueryMapKey.EMBED
import kr.co.kmmmami.data.utils.QueryMapKey.LIMIT
import kr.co.kmmmami.data.utils.QueryMapKey.LT
import kr.co.kmmmami.data.utils.QueryMapKey.OFFSET
import kr.co.kmmmami.domain.model.response.PointDownloadResponse
import kr.co.kmmmami.domain.model.response.PointResponse
import kr.co.kmmmami.domain.model.response.UserSelfPointResponse
import kr.co.kmmmami.domain.repository.PointRepository

class PointRepositoryImpl(private val myPointApi: MyPointApi) : PointRepository {
    override suspend fun getPoint(token: String): Flow<ResultData<PointResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    myPointApi.getPoint(
                        token
                    )
                }
            )
        }
    }

    override suspend fun getSelfPoints(
        lt: String,
        token: String,
    ): Flow<ResultData<UserSelfPointResponse>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                if (lt == "0")
                    this[OFFSET] = "0"
                else
                    this[LT] = lt

                this[LIMIT] = "30"
                this[EMBED] = "user-point,extinction-point"
            }

            emit(
                safeApiCallFlow {
                    myPointApi.getSelfPoints(
                        token,
                        queryMap
                    )
                }
            )
        }
    }

    override suspend fun postCouponsPoint(
        token: String,
        code: String,
    ): Flow<ResultData<PointDownloadResponse>> {
        val jsonObject = buildJsonObject {
            put("code", code)
        }

        return flow {
            emit(
                safeApiCallFlow {
                    myPointApi.postCouponsPoint(
                        token,
                        jsonObject
                    )
                }
            )
        }
    }
}
