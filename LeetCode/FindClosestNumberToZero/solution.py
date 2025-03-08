def findClosestNumber(self, nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    current_lowest = nums[0]

    for num in nums:
        if abs(num) < abs(current_lowest):
            current_lowest = num

    if current_lowest < 0 and abs(current_lowest) in nums:
        return abs(current_lowest)
    else:
        return current_lowest

