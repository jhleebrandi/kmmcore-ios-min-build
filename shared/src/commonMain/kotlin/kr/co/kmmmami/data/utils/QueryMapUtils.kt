package kr.co.kmmmami.data.utils

import kr.co.kmmmami.data.utils.QueryMapKey.LIMIT
import kr.co.kmmmami.data.utils.QueryMapKey.OFFSET

/**
 * Created by parkkks2@brandi.co.kr on 2021/01/14
 */
object QueryMapUtils {

    fun getPagingQueryMap(offset: Int = 0, limit: Int = 30): HashMap<String, String> {
        val queryMap = HashMap<String, String>()
        queryMap[OFFSET] = "$offset"
        queryMap[LIMIT] = "$limit"

        return queryMap
    }

    fun getQueryMapOnlyLimit(limit: Int = 30): HashMap<String, String> {
        val queryMap = HashMap<String, String>()
        queryMap[LIMIT] = "$limit"

        return queryMap
    }
}
