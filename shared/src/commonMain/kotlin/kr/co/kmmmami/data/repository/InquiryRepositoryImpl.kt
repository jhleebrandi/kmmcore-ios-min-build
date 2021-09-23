package kr.co.kmmmami.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.co.kmmmami.core_data.base.safeApiCallFlow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.core_data.model.RootData
import kr.co.kmmmami.data.networking.api.MyInquiryApi
import kr.co.kmmmami.data.utils.QueryMapKey.LIMIT
import kr.co.kmmmami.data.utils.QueryMapKey.LT
import kr.co.kmmmami.data.utils.QueryMapKey.OFFSET
import kr.co.kmmmami.data.utils.QueryMapKey.TYPE
import kr.co.kmmmami.data.utils.QueryMapUtils.getPagingQueryMap
import kr.co.kmmmami.domain.model.response.InquiriesListResponse
import kr.co.kmmmami.domain.model.response.QnaListResponse
import kr.co.kmmmami.domain.repository.InquiryRepository

class InquiryRepositoryImpl(private val myInquiryApi: MyInquiryApi) : InquiryRepository {

    override suspend fun getInquiryList(
        token: String,
        lt: String,
        type: String
    ): Flow<ResultData<InquiriesListResponse>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                if (lt.isNotEmpty())
                    this[LT] = lt
                else
                    this[OFFSET] = "0"

                this[LIMIT] = "30"
                this[TYPE] = type
            }

            emit(
                safeApiCallFlow {
                    myInquiryApi.getInquiryList(token, queryMap)
                }
            )
        }
    }

    override suspend fun getProductInquiryList(
        token: String,
        productId: String,
        offset: Int,
        isMyQna: Boolean
    ): Flow<ResultData<QnaListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(offset = offset).apply {
                this[TYPE] = if (isMyQna) "self" else "all"
            }

            emit(
                safeApiCallFlow {
                    myInquiryApi.getProductsInquiries(token, productId, queryMap)
                }
            )
        }
    }

    override suspend fun deleteProductsInquiries(
        token: String,
        productId: String,
        inquiryId: String,
    ): Flow<ResultData<RootData>> {
        return flow {
            emit(
                safeApiCallFlow {
                    myInquiryApi.deleteProductsInquiries(token, productId, inquiryId)
                }
            )
        }
    }
}
