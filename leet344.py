from typing import List

def reverseString(self, s: List[str]) -> None:
    s.reverse()

def reverseString(self, s: List[str]) -> None:
    last = len(s) - 1
    for i in range(len(s)):
        if i == last - i:
            break
        s[i], s[last] = s[last], s[i]
def reverseString(self, s: List[str]) -> None:
        last = len(s) - 1
        for i in range(len(s)):
            if i >= last - i:
                break
            s[i], s[last - i] = s[last - i], s[i]

def reverseString(self, s: List[str]) -> None:
    left, right = 0, len(s) - 1
    while left < right:
        s[left], s[right] = s[right], s[left]
        left += 1
        right -= 1 
