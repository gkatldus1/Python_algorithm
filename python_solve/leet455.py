import bisect
from typing import List

def findContentChildren(self, g: List[int], s: List[int]) -> int:
    g.sort()
    s.sort()

    child_i = cookie_j = 0

    while child_i < len(g) and cookie_j < len(s):
        if s[cookie_j] >= g[child_i]:
            child_i += 1
        cookie_j += 1

    return child_i

def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        child_num = 0
        for i in range(len(s)):
            if child_num < len(g) and s[i] >= g[child_num]:
                child_num += 1
        return child_num
        
def findContentChildren(self, g: List[int], s: List[int]) -> int:
    g.sort()
    s.sort()

    result = 0
    for i in s:
        index = bisect.bisect_right(g, i)
        if index > result:
            result += 1
    return result