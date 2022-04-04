import re
import collections
from typing import *

def isPalindrome(self, s: str) -> bool:
    s = re.findall('[a-zA-Z0-9]', s.lower())
    s = "".join(s)
    return(s == s[::-1])

def isPalindrome(self, s: str) -> bool:
    strs = []
    for char in s:
        if char.isalnum():
            strs.append(char.lower())
    
    while len(strs) > 1:
        if strs.pop(0) != strs.pop():
            return False
    
    return True

def isPalindrome(self, s: str) -> bool:
    strs: Deque = collections.deque()

    for char in s:
        if char.isalnum():
            strs.append(char.lower())
    
    while len(strs) > 1:
        if strs.popleft() != strs.pop():
            return False
    return True

def isPalindrome(self, s: str) -> bool:
    s = s.lower()
    s = re.sub('[^a-z0-9]', '', s)

    return s == s[::-1]