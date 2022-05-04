import sys
import collections
input = sys.stdin.readline

T = int(input())
for i in range(T):
    N = int(input())
    _list = []
    nums = input()
    for k in nums:
        _list.append(int(k))
    count = collections.Counter(_list)
    ans = count.most_common()
    ans = sorted(ans, key=lambda x: (-x[1], -x[0]))
    print("#{} {} {}".format(i+1, ans[0][0], ans[0][1]))
    

import math
T = int(input())

for i in range(T):
    N = input()
    nums = input()
    _list = [0 for i in range(10)]
    max_num = - math.inf
    max_idx = -1
    for k in nums:
        _list[int(k)] += 1
    for j in range(len(_list)):
        if _list[j] >= max_num:
            max_num = _list[j]
            max_idx = j
    print("#{} {} {}".format(i+1, max_idx, max_num))
