package cn.inrhor.interestingpacket.utils

import java.util.regex.Pattern

object Check {

    fun isNumber(string: String): Boolean {
        val pattern = Pattern.compile("[0-9]*")
        return pattern.matcher(string).matches()
    }
}