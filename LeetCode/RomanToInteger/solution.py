def romanToInt(s):
    """
    :type s: str
    :rtype: int
    """
    value_map = {
        "I": 1,
        "V": 5,
        "X": 10,
        "L": 50,
        "C": 100,
        "D": 500,
        "M": 1000
    }

    output_value = 0
    for i in range(len(s)):
        if i < len(s) -1 and value_map[s[i]] < value_map[s[i+1]]:
            output_value -= value_map[s[i]]
        else:
            output_value += value_map[s[i]]
    return output_value



if __name__ == '__main__':
    print(romanToInt("III"))
    print(romanToInt("LVIII"))
    print(romanToInt("MCMXCIV"))
