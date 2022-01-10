def lengthOfLongestSubstring(self, s: str) -> int:
    used = {}
    max_length = start = 0
    for index, char in enumerate(s):
        if char in used and start <= used[char]:
            start = used[char] + 1 # 여기서 used[char]는 이번의 위치가 아닌 이전에 갱신된 위치이다.
        else:
            max_length = max(max_length, index - start + 1)
        
        used[char] = index
    
    return max_length