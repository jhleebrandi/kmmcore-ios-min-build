package kr.co.kmmmami.domain.repository

interface OrderSessionRepository {
    var paymentType: Int
    val tossToken: String?
    val tossStatus: String?
    val tossOrderNumber: String?

    fun putTossLink(url: String?)
}
