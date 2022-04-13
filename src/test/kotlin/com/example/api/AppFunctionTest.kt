package com.example.api

import com.example.app.AppClient
import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions.assertEquals

//1
class AppFunctionTest : Spek({

    describe("app function") {
        //2
        val server = ApplicationContext.run(EmbeddedServer::class.java)
        //3
        val client = server.applicationContext.getBean(AppClient::class.java)

        it("should return Boker tov") {
            val input = HandlerInput("Bom dia")
            val output = client.apply(input).hebrewMessage
            //4
            assertEquals("Boker tov", output)
        }

        afterGroup { server.stop() }
    }
})

/*
    Aqui você faz o seguinte:
    1 - Teste usando Spek – uma estrutura de especificação que permite definir facilmente as especificações de maneira
        clara, compreensível e legível por humanos.
    2 - Inicie um servidor incorporado Netty dentro de seu teste.
    3 - Recupere o cliente declarativo para consumir a função.
    4 - Retorna o o resultado do teste
    Obs: è necessário instalar o plugin Spek no Intellij e caso não queira é possível rodar o teste com a anotação
    @RunWith(Suite::class) colocada na classe
*/