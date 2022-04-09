import sys
import collections
import re
import pprint
from zlib import Z_BEST_COMPRESSION

# c = Counter(a=4, b=2, c=0, d=-2)
# print(c)
# print(sorted(c.elements()))

# print(Counter('abraccadabra'))
# print(Counter([1,1,2,3,5,3,2,1]))
# N = int(sys.stdin.readline())
# cards = [int(sys.stdin.readline()) for _ in range(N)]

# print(cards)

# count = Counter(cards)
# # print(count)

# count = Counter(sorted(cards))
# # print(count)
# print(count.most_common(1)[0][0])

# nums = [9,10,11,4,5,6,7,8]
# left, right = 0, len(nums) - 1
# while left < right:
#     mid = left + (right - left) // 2

#     if nums[mid] > nums[right]:
#         left = mid + 1
#     else:
#         right = mid

# pivot = left
# print(nums[pivot])

# str1s = [
#         str1[i:i + 2].lower()
#         for i in range(len(str1) - 1) if re.findall('[a-z]{2}', str1[i:i + 2].lower())
#     ]
str1 = "aa1+aa2"
str1s = []
# for i in range(len(str1) - 1):
#     if re.findall('[a-z]{2}', str1[i:i + 2].lower()):
#         str1s.append(str1[i:i + 2].lower())
# print (str1s)
# for i in range(len(str1) - 1):
#     print(re.findall('[a-z]{2}', str1[i:i + 2].lower()))
# ex = re.findall(r'\bf[a-z]*', 'which foot or hand fell fastest')
# nums = [1,3,4,6,4,3]
# _dic = collections.defaultdict(int)
# for i in range(10):
#     _dic[i] = i
# pprint.pprint(locals())
nums = [(x, y, z) 
    for x in range(5)
    for y in range(5)
    if x != y
    for z in range(5)
    if y != z
]
print(nums)