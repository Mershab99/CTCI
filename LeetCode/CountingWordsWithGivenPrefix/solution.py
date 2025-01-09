def prefixCount(words, pref):
    """
    :type words: List[str]
    :type pref: str
    :rtype: int
    """

    word_count = 0
    for s in words:
        if s[0:len(pref)] == pref:
            word_count+=1
    return word_count



words = ["pay","attention","practice","attend"]

print(prefixCount(words, pref="at"))
x = 1
