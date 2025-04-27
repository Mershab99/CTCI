def findRepeatedDnaSequences(s):
    seen = set()
    repeated = set()

    for i in range(len(s) - 9):
        substr = s[i:i+10]
        if substr in seen:
            repeated.add(substr)
        else:
            seen.add(substr
    return list(repeated)

