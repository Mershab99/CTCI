def plusOne(digits):
    """
    :type digits: List[int]
    :rtype: List[int]
    """
    n = len(digits)
    
    # Traverse the list in reverse
    for i in range(n - 1, -1, -1):
        if digits[i] < 9:
            digits[i] += 1
            return digits
        # If the digit is 9, set it to 0
        digits[i] = 0
    
    # If all the digits were 9, we need to add an extra 1 at the beginning
    return [1] + digits

# Example Test Cases
print(plusOne([1, 2, 3]))  # Output: [1, 2, 4]
print(plusOne([4, 3, 2, 1]))  # Output: [4, 3, 2, 2]
print(plusOne([9]))  # Output: [1, 0]
print(plusOne([9, 9, 9]))  # Output: [1, 0, 0, 0]
