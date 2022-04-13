package com.example

import com.example.api.AppFunction
import com.example.api.HandlerInput
/**
 * Este método principal permite executar a função como um aplicativo CLI usando: echo '{}' | java -jar function.jar
 * onde o argumento para echo é o JSON a ser analisado.
 */
fun main(args: Array<String>) {
    val function = AppFunction()
    function.run(args) { context ->
        function.apply(context.get(HandlerInput::class.java))
    }
}

