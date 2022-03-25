import collections
from typing import List

def solution(cacheSize: int, cities: List[str]) -> int:
    elapsed : int = 0
    cache = collections.deque(maxlen=cacheSize)

    if cacheSize == 0:
        return 5 * len(cities)

    for c in cities:
        c = c.lower()
        if c in cache:
            cache.remove(c)
            cache.append(c)
            elapsed += 1
        else:
            cache.append(c)
            elapsed += 5

    return elapsed
