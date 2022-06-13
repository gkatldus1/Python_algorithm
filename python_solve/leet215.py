import heapq

def findKthLargest(self, nums: List[int], k: int) -> int:
    heap = list()
    for n in nums:
        heapq.heappush(heap, -n)

    for _ in range(k-1):
        heapq.heappop(heap)

    return -heapq.heappop(heap)


def findKthLargest(self, nums: List[int], k: int) -> int:
    heapq.heapify(nums)

    for _ in range(len(nums) - k):
        heapq.heappop(nums)

    return heapq.heappop(nums)

def findKthLargest(self, nums: List[int], k: int) -> int:
    return heapq.nlargest(k, nums)[-1]

def findKthLargest(self, nums: List[int], k: int) -> int:
    return sorted(nums, reverse=True)[k-1]
