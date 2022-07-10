from typing import List

def arrayPairSum(self, nums: List[int]) -> int:
    nums.sort()
    max_results = 0
    for i in range(0, len(nums), 2):
        max_results += nums[i]
    
    return max_results

def arrayPairSum(self, nums: List[int]) -> int:
    sum = 0
    pair = []
    nums.sort()

    for n in nums:
        pair.append(n)
        if len(pair) == 2:
            sum += min(pair)
            pair = []
    return sum

def arrayPairSum(self, nums: List[int]) -> int:
    sum = 0
    nums.sort()

    for i, n in enumerate(nums):
        if i % 2 == 0:
            sum += n
    return sum

def arrayPairSum(self, nums: List[int]) -> int:
    return sum(sorted(nums)[::2])