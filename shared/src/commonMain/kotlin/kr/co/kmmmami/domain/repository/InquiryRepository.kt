package kr.co.kmmmami.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.core_data.model.RootData
import kr.co.kmmmami.domain.model.response.InquiriesListResponse
import kr.co.kmmmami.domain.model.response.QnaListResponse

interface InquiryRepository {
    suspend fun getInquiryList(
        token: String,
        lt: String,
        type: String
    ): Flow<ResultData<InquiriesListResponse>>

    suspend fun getProductInquiryList(
        token: String,
        productId: String,
        offset: Int = 0,
        isMyQna: Boolean
    ): Flow<ResultData<QnaListResponse>>

    suspend fun deleteProductsInquiries(
        token: String,
        productId: String,
        inquiryId: String,
    ): Flow<ResultData<RootData>>
}
