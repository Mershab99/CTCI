def removeDuplicates(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    j = 1
    for i in range(1, len(nums)):
        if nums[i] != nums[i - 1]:
            nums[j] = nums[i]
            j += 1
    return j


nums1 = [1, 1, 2]
print(removeDuplicates(nums1))
print(nums1)
