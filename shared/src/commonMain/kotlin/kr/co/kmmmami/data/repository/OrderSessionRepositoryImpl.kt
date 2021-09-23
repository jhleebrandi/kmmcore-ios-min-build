package kr.co.kmmmami.data.repository

import kr.co.kmmmami.data.local.OrderSessionSharedPreferences
import kr.co.kmmmami.domain.repository.OrderSessionRepository

class OrderSessionRepositoryImpl(
    private val orderSession: OrderSessionSharedPreferences
) : OrderSessionRepository {
    override var paymentType: Int
        get() = orderSession.paymentType
        set(value) {
            orderSession.paymentType = value
        }
    override val tossToken: String?
        get() = orderSession.tossToken

    override val tossStatus: String?
        get() = orderSession.tossStatus

    override val tossOrderNumber: String?
        get() = orderSession.tossOrderNumber

    override fun putTossLink(url: String?) {
        orderSession.putTossLink(url)
    }
}
