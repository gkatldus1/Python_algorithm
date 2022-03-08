from typing import List
import collections

def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:   
    if not nums:
        return nums
    
    r = []
    for i in range(len(nums) - k + 1):
        r.append(max(nums[i:i + k]))
    
    return r

def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:   
    results = []
    window = collections.deque()
    current_max = float('-inf')
    for i, v in enumerate(nums):
        window.append(v)
        if i < k - 1:
            continue
        
        if current_max == float('-inf'):
            current_max = max(window)
        elif v > current_max:
            current_max = v
        
        results.append(current_max)

        if current_max == window.popleft():
            current_max = float('-inf')
    return results

def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
    deq, ans = collections.deque(), []

    for i in range(len(nums)):
        # 앞에서부터 out of window -> 제거
        if deq and i-deq[0] == k:
            deq.popleft()

        # 뒤에서부터 현재 추가할 숫자보다 작으면 -> 제거 (deq에 불필요한 숫자 없도록!)
        while deq and nums[deq[-1]] <= nums[i]:
            deq.pop()

        deq.append(i) # 현재 숫자 추가( (i, num[i])로 저장해도 되나, 숫자 위치 저장만 해 space 줄임)

        # 출력 부분 (현재 위치 >= window size일 때)
        if i+1 >= k:
            ans.append(nums[deq[0]])  # 맨 앞은 현재 window 에서 가장 큰 수

    return ans