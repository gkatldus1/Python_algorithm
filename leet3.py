# import collections
# def lengthOfLongestSubstring(self, s: str) -> int:
#     _dict = collections.defaultdict(int)
#     length = 0
#     max_len = 0
#     for char in s:
#         if _dict[char] == 0:
#             _dict[char] += 1
#             length += 1
#         else:
#             if length > max_len:
#                 max_len = length
#             length = 1
#             _dict[char] = 1



def lengthOfLongestSubstring(s: str) -> int:
    used = {}
    max_length = start = 0
    for index, char in enumerate(s):
        if char in used and start <= used[char]:
            start = used[char] + 1
        else:
            max_length = max(max_length, index - start + 1)
        
        used[char] = index
    
    return max_length
s = input()
ans = lengthOfLongestSubstring(s)
print(ans)