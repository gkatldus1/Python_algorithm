import sys
import math
input = sys.stdin.readline

#prime_nums = []
# def is_prime(num):
#     if num in prime_nums:
#         print(num)
#         return
#     else:
#         sqrtn = int(math.sqrt(num))
#         for i in range(2, (sqrtn+1)):
#             if (num % i) == 0:
#                 return False
#         prime_nums.append(num)
#         print(num)
#         return
def is_prime(num):
    sqrtn = int(math.sqrt(num))
    for i in range(2, (sqrtn+1)):
        if (num % i) == 0:
            return False
    return True

M, N = map(int, input().split())
for i in range(M, N+1):
    if i == 1:
        continue
    if is_prime(i):
        print(i)
