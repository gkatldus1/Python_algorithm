from typing import List
import sys

def maxSubArray(self, nums: List[int]) -> int:
    sums: List[int] = [nums[0]]
    for i in range(1, len(nums)):
        sums.append(nums[i] + (sums[i - 1] if sums[i - 1] > 0 else 0))

    return max(sums)

def maxSubArray(self, nums: List[int]) -> int:
    for i in range(1, len(nums)):
        nums[i] += nums[i - 1] if nums[i - 1] > 0 else 0
    return max(nums)

def maxSubArray(self, nums: List[int]) -> int:
    best_sum = -sys.maxsize
    current_sum = 0
    for num in nums:
        current_sum = max(num, current_sum + num)
        best_sum = max(best_sum, current_sum)

    return best_sum