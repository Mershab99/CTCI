from collections import Counter

def findLHS(nums: List[int]):
    freq = Counter(nums)

    max_len = 0
    for key in freq:
        if key+1 in freq:
            max_len = max(max_len, freq[key] + freq[key + 1])
    return max_len

