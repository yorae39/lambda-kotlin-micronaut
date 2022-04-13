package com.example.extra

class FizzBuzz : FizzBuzzi {
    override fun calculate(num: Int): String {
        if (num % 3 == 0) return "Fizz"
        if (num % 5 == 0) return "Buzz"
        return num.toString()
    }
}

interface FizzBuzzi {
    fun calculate(num: Int): String
}