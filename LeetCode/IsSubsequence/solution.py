def isSubsequence(self, s, t):
    """
    :type s: str
    :type t: str
    :rtype: bool
    """

    s_pointer = t_pointer =  matched_count = 0

    while s_pointer < len(s) and t_pointer < len(t):
        if (s[s_pointer] == t[t_pointer]):
            s_pointer += 1
            t_pointer += 1
            matched_count += 1
        else:
            t_pointer += 1
    return matched_count == len(s)
