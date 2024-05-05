class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        str_x = str(x)

        start_index = 0
        end_index = len(str_x) - 1

        while start_index < end_index:
            if str_x[start_index] != str_x[end_index]:
                return False
            else:
                start_index += 1
                end_index -= 1
        return True
