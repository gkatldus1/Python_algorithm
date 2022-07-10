import sys
import math
input = sys.stdin.readline

answer = 0
def is_prime(num):
    sqrtn = int(math.sqrt(num))
    for i in range(2, (sqrtn+1)):
        if (num % i) == 0:
            return False
    return True

N = int(input())
nums = list(map(int, input().split()))
for i in range(N):
    if nums[i] == 1:
        continue
    if is_prime(nums[i]):
        answer += 1
print(answer)
