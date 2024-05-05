class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs) == 1:
            return strs[0]

        shortest_str = min(strs, key=len)
        common_prefix = ""

        for index in range(len(shortest_str)):
            curr_char = shortest_str[index]

            if all(s[index] == curr_char for s in strs):
                common_prefix += curr_char
            else:
                break

        return common_prefix
