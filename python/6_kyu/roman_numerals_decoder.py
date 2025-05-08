"""
Create a function that takes a Roman numeral as its argument and returns its value as a numeric decimal integer.
You don't need to validate the form of the Roman numeral.

Modern Roman numerals are written by expressing each decimal digit of the number to be encoded separately,
starting with the leftmost digit and skipping any 0s. So 1990 is rendered "MCMXC" (1000 = M, 900 = CM, 90 = XC)
and 2008 is rendered "MMVIII" (2000 = MM, 8 = VIII). The Roman numeral for 1666, "MDCLXVI",
uses each letter in descending order.
Example:

"MM"      -> 2000
"MDCLXVI" -> 1666
"M"       -> 1000
"CD"      ->  400
"XC"      ->   90
"XL"      ->   40
"I"       ->    1

Help:

Symbol    Value
I          1
V          5
X          10
L          50
C          100
D          500
M          1,000


"CD"      ->  400

Primeiro caractere analisado? C
Próximo caractere é igual ou menor? Somar o valor e verificar o próximo caractere.
Próximo caractere é maior? Subtrair o valor deste caractere e verificar o próximo caractere.

"MM"      -> 2000
"MDCLXVI" -> 1666
"M"       -> 1000
"CD"      ->  400
"XC"      ->   90
"XL"      ->   40
"I"       ->    1
"""

def solution(roman : str) -> int:
    dict_roman_values = {
        "M": 1000,
        "D": 500,
        "C": 100,
        "L": 50,
        "X": 10,
        "V": 5,
        "I": 1,
    }

    total = 0
    for index, char in enumerate(roman):
        current_value = dict_roman_values[char]
        if index + 1 < len(roman):
            next_value = dict_roman_values[roman[index + 1]]
            if current_value < next_value:
                total -= current_value
            else:
                total += current_value
        else:
            total += current_value

    return total


assert solution('MMMCMXCIX') == 3999, "Should be 3999"
assert solution('MMMDCCCLXXXVIII') == 3888, "Should be 3888"
assert solution('MM') == 2000, "Should be 2000"
assert solution('MDCLXVI') == 1666, "Should be 1666"
assert solution('M') == 1000, "Should be 1000"
assert solution('CD') == 400, "Should be 400"
assert solution('XC') == 90, "Should be 90"
assert solution('XL') == 40, "Should be 40"
assert solution('I') == 1, "Should be 1"