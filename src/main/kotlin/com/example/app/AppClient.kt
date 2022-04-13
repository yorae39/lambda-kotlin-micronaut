package com.example.app

import com.example.api.HandlerInput
import com.example.api.HandlerOutput
import java.util.function.Function

interface AppClient : Function<HandlerInput, HandlerOutput> {
    override fun apply(input: HandlerInput): HandlerOutput
}
