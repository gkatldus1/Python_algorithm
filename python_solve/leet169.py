from typing import List
import collections

def majorityElement(self, nums: List[int]) -> int:
    for num in nums:
        if nums.count(num) > len(nums) // 2:
            return num

def majorityElement(self, nums: List[int]) -> int:
    counts = collections.defaultdict(int)
    for num in nums:
        if counts[num] == 0:
            counts[num] = nums.count(num)

        if counts[num] > len(nums) // 2:
            return num

def majorityElement(self, nums: List[int]) -> int:
    if not nums:
        return None
    if len(nums) == 1:
        return nums[0]

    half = len(nums) // 2
    a = self.majorityElement(nums[:half])
    b = self.majorityElement(nums[half:])

    return [a, b][nums.count(b) > half]

def majorityElement(self, nums: List[int]) -> int:
    return sorted(nums)[len(nums) // 2]