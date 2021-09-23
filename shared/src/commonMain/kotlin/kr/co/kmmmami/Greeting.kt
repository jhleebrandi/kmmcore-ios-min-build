package kr.co.kmmmami

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}