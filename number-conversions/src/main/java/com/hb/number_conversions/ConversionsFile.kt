package com.hb.number_conversions

import kotlin.math.abs
import kotlin.math.pow

//binary
fun binaryToDecimal(binaryString: String): String {
    var decimal = 0

    for ((power, i) in (binaryString.length - 1 downTo 0).withIndex()) {
        val digit = binaryString[i].toString().toInt()
        if (digit == 1 || digit == 0) {
            decimal += digit * 2.0.pow(power.toDouble()).toInt()
        } else {
            return "Invalid binary number. Please enter only 0s and 1s."
        }
    }
    return decimal.toString()
}

fun binaryToOctal(binaryNumber: String): String {
    if (!binaryNumber.matches(Regex("^[01]+$"))) {
        return "Invalid binary number. Please enter only 0s and 1s."
    }
    if (binaryNumber.isEmpty()) {
        return "0"
    }
    val paddedBinary = binaryNumber.padStart(
        (binaryNumber.length + 2) / 3 * 3,
        '0'
    )

    val octalNumber = StringBuilder()
    for (i in paddedBinary.indices step 3) {
        val octalDigit =
            paddedBinary.substring(i, i + 3).toInt(2)
        octalNumber.append(octalDigit.toString(8))
    }

    return octalNumber.toString().toUpperCase()
}


fun binaryToHex(binary: String): String {
    // Ensure the input string is a valid binary string
    if (!binary.matches(Regex("[01]+"))) {
        return "Invalid binary input"
    }

    // Convert binary to decimal
    val decimal = binary.toLong(2)

    // Convert decimal to hexadecimal
    val hexString = java.lang.Long.toHexString(decimal)

    return hexString.toUpperCase()
}



//Decimal

fun decimalToBinary(decimalNumber: Int): String {
    val absoluteNumber = abs(decimalNumber)
    if (absoluteNumber == 0) {
        return "0"
    }
    var binaryString = ""
    var number = absoluteNumber
    while (number > 0) {
        binaryString = "${number % 2}$binaryString"
        number /= 2
    }

    if (decimalNumber < 0) {
        binaryString = "-$binaryString"
    }

    return binaryString
}

fun decimalToOctal(decimalNumber: Int): String {
    val absoluteNumber = abs(decimalNumber)

    if (absoluteNumber == 0) {
        return "0"
    }
    var octalString = ""
    var number = absoluteNumber
    while (number > 0) {
        octalString = "${number % 8}$octalString"
        number /= 8
    }
    if (decimalNumber < 0) {
        octalString = "-$octalString"
    }

    return octalString
}

fun decimalToHexadecimal(decimalNumber: Int): String {
    val absoluteNumber = abs(decimalNumber)

    if (absoluteNumber == 0) {
        return "0"
    }

    var hexString = ""
    var number = absoluteNumber
    val hexDigits = "0123456789ABCDEF"

    while (number > 0) {
        val remainder = number % 16
        hexString = hexDigits[remainder] + hexString
        number /= 16
    }


    if (decimalNumber < 0) {
        hexString = "-$hexString"
    }

    return hexString.uppercase()
}

//octal

fun octalToBinary(octalNumber: String): String {
    if (!octalNumber.matches(Regex("[0-7]+"))) {
        return "string must contains only digits from 0 to 7."
    }

    if (octalNumber.isEmpty()) {
        return "0"
    }

    val decimalNumber = octalToDecimal(octalNumber).toInt()

    return decimalToBinary(decimalNumber)
}

fun octalToDecimal(octalNumber: String): String {
    if (!octalNumber.matches(Regex("[0-7]+"))) {
        return "Invalid octal input. Please enter a string containing only digits from 0 to 7."
    }

    if (octalNumber.isEmpty()) {
        return "0"
    }

    var decimalValue = 0
    var power = 1
    octalNumber.reversed().forEach { octalDigit ->
        val digitValue = octalDigit.toInt() - '0'.toInt()
        if (digitValue > 7) {
            return "Invalid octal digit: $digitValue"
        }
        decimalValue += digitValue * power
        power *= 8
    }

    return decimalValue.toString()
}

fun octalToHexadecimal(octalNumber: String): String {
    if (!octalNumber.matches(Regex("[0-7]+"))) {
        return "Invalid octal input. Please enter a string containing only digits from 0 to 7."
    }

    if (octalNumber.isEmpty()) {
        return "0"
    }

    val decimalValue = octalToDecimal(octalNumber)

    return decimalToHexadecimal(decimalValue.toInt())
}

//hexadecimal

fun hexToBinary(hexString: String): String {
    if (!hexString.matches(Regex("[0-9A-Fa-f]+"))) {
        return "string must contains only hexadecimal digits (0-9, A-F, a-f)."
    }
    if (hexString.isEmpty()) {
        return "0"
    }

    val decimalNumber = hexToDecimal(hexString).toInt()



    return decimalToBinary(decimalNumber)
}

fun hexToDecimal(hex: String): String {
    if (!hex.matches(Regex("[0-9A-Fa-f]+"))) {
        return "Invalid hexadecimal input"
    }

    return Integer.parseInt(hex, 16).toString()
}


fun hexToOctal(hexString: String): String {
    if (!hexString.matches(Regex("[0-9A-Fa-f]+"))) {
        return "Invalid hexadecimal input. Please enter a string containing only hexadecimal digits (0-9, A-F, a-f)."
    }

    if (hexString.isEmpty()) {
        return "0"
    }

    val decimalValue = hexToDecimal(hexString)


    return decimalToOctal(decimalValue.toInt())
}