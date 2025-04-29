def containsNearbyDuplicate(nums: List[int], k: int) -> bool:
    hset = defaultdict(int)

    for idx, val in enumerate(nums):
        if val in hset and abs(idx - hset[val]) <= k:
            return True
        else:
            hset[val] = idx
    return False
