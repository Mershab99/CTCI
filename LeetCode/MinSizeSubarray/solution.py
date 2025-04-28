def minSubArrayLen(target: int, nums: List[int]) -> int:
    left, summation = 0,0

    # Make length out of bounds to start with
    min_len = len(nums) + 1

    for right in range(len(nums)):
        summation += nums[right]
        while summation >= target:
            min_len = min(min_len, right-left+1)
            summation -= nums[left]
            left += 1
    return min_len if min_len != len(nums)+1 else 0

