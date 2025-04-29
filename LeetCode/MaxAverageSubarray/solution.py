def findMaxAverage(nums: List[int], k: int) -> float:
    max_sum = sum(nums[0:k])
    total = max_sum

    for i in range(k, len(nums)):
        total += nums[i] - nums[i-k]
        if (total > max_sum):
            max_sum = total
    return max_sum/float(k)
