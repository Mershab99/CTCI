def addBinary(a, b):
    """
    :type a: str
    :type b: str
    :rtype: str
    """
    result = []
    carry = 0
    i, j = len(a) - 1, len(b) - 1

    # Traverse both strings from the end
    while i >= 0 or j >= 0 or carry:
        # Get the binary digits from each string or 0 if the index is out of range
        digit_a = int(a[i]) if i >= 0 else 0
        digit_b = int(b[j]) if j >= 0 else 0
        
        # Sum of the digits and the carry
        total = digit_a + digit_b + carry
        carry = total // 2  # Update carry
        result.append(total % 2)  # Append the remainder (0 or 1) to the result
        
        # Move to the next digits
        i -= 1
        j -= 1

    # Since we built the result backwards, reverse it
    return ''.join(map(str, result[::-1]))

# Example Test Cases
print(addBinary("11", "1"))     # Output: "100"
print(addBinary("1010", "1011"))  # Output: "10101"
