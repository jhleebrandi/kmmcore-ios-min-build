package kr.co.kmmmami.data.local

interface OrderSessionSharedPreferences {

    var paymentType: Int

    val tossToken: String?

    val tossStatus: String?

    val tossOrderNumber: String?

    fun deleteSession()

    fun putTossLink(url: String?)

}
