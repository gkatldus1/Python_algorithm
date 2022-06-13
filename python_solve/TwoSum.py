from typing import List
def twoSum(nums: List[int], target: int) -> List[int]:
    left, right = 0, len(nums) -1
    # nums.sort()
    while not left == right:
        if nums[left] + nums[right] < target:
            left += 1
        elif nums[left] + nums[right] > target:
            right -=1
        else:
            return left, right




nums = list(map(int, input("입력:").split()))
print(nums)
answer = twoSum(nums, 9)
print(answer)