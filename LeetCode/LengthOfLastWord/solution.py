def lengthOfLastWord(s):
    """
    :type s: str
    :rtype: int
    """
    words = s.split()
    return len(words[-1])

test_string = "Hello World"


assert lengthOfLastWord(test_string) == 5
