from typing import List
import heapq
import math

def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
    heap = []
    for (x, y) in points:
        dist = math.sqrt((0 - x)**2 + (0 - y)**2)
        heapq.heappush(heap, (dist, x, y))

    result = []
    for _ in range(K):
        (dist, x, y) = heapq.heappop(heap)
        result.append((x, y))
    
    return result