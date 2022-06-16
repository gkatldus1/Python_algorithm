import collections
import heapq
from typing import *

def topKFrequent(self, nums: List[int], k: int) -> List[int]:
    freqs = collections.Counter(nums)
    freqs_heap = []
    for f in freqs:
        heapq.heappush(freqs_heap, (-freqs[f], f))
    ans = list()
    for _ in range(k):
        ans.append(heapq.heappop(freqs_heap)[1])
    return ans

def topKFrequent(self, nums: List[int], k: int) -> List[int]:
    return list(zip(*collections.Counter(nums).most_common(k)))[0]