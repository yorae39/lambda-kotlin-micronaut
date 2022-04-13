package com.example.api

import com.example.app.AppClient
import io.micronaut.function.FunctionBean
import io.micronaut.function.executor.FunctionInitializer

@FunctionBean("hebrew-phrase-translator")
class AppFunction : FunctionInitializer(), AppClient {

    private val translator: HebrewPhraseTranslator = DefaultHebrewPhraseTranslator()

    override fun apply(input: HandlerInput): HandlerOutput {
        return HandlerOutput(input.message, translator.translate(input.message))
    }
}