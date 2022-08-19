package com.sonth.mvvm.sample.utils.validator

import java.util.regex.Pattern

object EmailValidator {
    private val pattern: Pattern by lazy {
        Pattern.compile(
            "[a-zA-Z0-9+._%\\-]{1,256}" +
                    "@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
    }

    fun isValid(input: String?): Boolean {
        return input != null && input.isNotEmpty() && pattern.matcher(
            input
        ).matches()
    }
}

object PasswordValidator {
    private val pattern: Pattern by lazy {
        Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9.\\-]{0,32}")
    }

    fun isValid(input: String?): Boolean {
        return input != null && input.isNotEmpty() && pattern.matcher(
            input
        ).matches()
    }
}