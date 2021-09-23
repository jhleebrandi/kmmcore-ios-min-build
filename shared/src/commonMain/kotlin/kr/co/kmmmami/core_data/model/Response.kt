package kr.co.kmmmami.core_data.model

import kotlinx.serialization.Serializable

@Serializable
abstract class Response {
    abstract val meta: Meta?
}
