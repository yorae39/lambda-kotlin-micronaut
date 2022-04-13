package com.example.api

class DefaultHebrewPhraseTranslator : HebrewPhraseTranslator {
    // FONTE: http://pt.nemolanguageapps.com/phrasebooks/hebrew
    private val replacements = mapOf(
        "Obrigado" to "Toda",
        "Por favor" to "Bevakasha",
        "Tchau" to "Lehitra'ot",
        "Lindo" to "Yafe",
        "Gostoso" to "Ta'im",
        "Eu gosto" to "Ze motze ĥen be'eynay",
        "Bem vindo" to "Bruĥim haba'im",
        "Bom dia" to "Boker tov",
        "Boa tarde" to "Tzaraiim Tovim",
        "Boa noite" to "Layla tov",
        "Muito obrigado" to "Toda raba",
        "De nada" to "'Eyn be'ad ma",
        "Parabéns" to "Mazal tov"
    )

    override fun translate(phrase: String): String {
        var result = phrase
        replacements.forEach { (k,v) -> result = result.replace(k,v)  }
        return result
    }
}

