def minimumDifference(nums: List[int], k: int) -> int:
    if len(nums) == 1:
        return 0

    nums.sort()

    cur_min = 10000001
    n = len(nums)

    l = 0
    r = k-1

    while r < n:
        cur_min = min(cur_min, nums[r] - nums[l])
        l +=1
        r +=1
    return cur_min



