from tkinter import N
from typing import List

def twoSum(self, nums: List[int], target: int) -> List[int]:
    ans = []
    for i in range(len(nums) - 1):
        for j in range(i + 1, len(nums)):
            if nums[i] + nums[j] == target:
                return [i,j]

def twoSum(self, nums: List[int], target: int) -> List[int]:
    for i, n in enumerate(nums):
            complement = target - n

            if complement in nums[i + 1:]:
                return [i, nums[i + 1:].index(complement) + (i + 1)]          
        