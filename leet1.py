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
        
def twoSum(self, nums: List[int], target: int) -> List[int]:
    nums_map = {}

    for i, num in enumerate(nums):
        nums_map[num] = i

    for i, num in enumerate(nums):
        if target - num in nums_map and i != nums_map[target - num]:
            return [i, nums_map[target - num]]

def twoSum(self, nums: List[int], target: int) -> List[int]:
    nums_map = {}

    for i, num in enumerate(nums):
        if target - num in nums_map and i != nums_map[target - num]:
            return [nums_map[target - num], i]
        
        nums_map[num] = i

def twoSum(self, nums: List[int], target: int) -> List[int]:
    left, right = 0, len(nums) - 1
    while not left == right:
        sum_ = nums[right] + nums[left]

        if sum_ < target:
            left += 1
        elif sum_ > target:
            right -= 1
        else:
            return left, right


        