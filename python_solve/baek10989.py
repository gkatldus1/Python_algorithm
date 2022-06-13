# import sys
# input = sys.stdin.readline

# N = int(sys.stdin.readline())
# nums = [int(sys.stdin.readline()) for _ in range(N)]
# nums.sort()
# print(nums)
import sys
input = sys.stdin.readline
n = int(input())
b = [0] * 10001
for i in range(n):
    b[int(input())] += 1
for i in range(10001):
    if b[i] != 0:
        for j in range(b[i]):
            print(i)
