package com.example.demo.exercises

// https://www.macoratti.net/alg_cnpj.htm
class ValidationCNPJExercise {
    private val multipliers = listOf(6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)

    fun validationCNPJ(cnpj: String): String {
        val formattedCNPJ = cnpj.replace(Regex("[^0-9]"), "")

        if (formattedCNPJ.length != 14 || formattedCNPJ == "00000000000000") {
            return "Invalid CNPJ number!"
        }

        val resPenultValue = multipleValues(multipliers, formattedCNPJ, 1, 12)
        val isValidPenult = resultDigit(resPenultValue, formattedCNPJ, 12)

        val resLastValue = multipleValues(multipliers, formattedCNPJ, 0 , 13)
        val isValidLast = resultDigit(resLastValue, formattedCNPJ, 13)

        if (isValidPenult || isValidLast) {
            return "Valid CNPJ number!"
        }

        return "Invalid CNPJ number!"
    }

    private fun multipleValues(multipliers: List<Int>, formattedCNPJ: String, sumValue: Int, maxValue: Int): Int {
        var currentValue = 0
        for (i in 0 until maxValue) {
            currentValue += Character.getNumericValue(formattedCNPJ[i]) * multipliers[i + sumValue]
        }
        return currentValue
    }

    private fun resultDigit(value: Int, formattedCNPJ: String, index: Int): Boolean {
        val calculateDigit = if ((value % 11) < 2) 0 else 11 - (value % 11)
        val penultimateDigit = Character.getNumericValue(formattedCNPJ[index])
        if (penultimateDigit != calculateDigit) {
            return false
        }
        return true
    }

}
