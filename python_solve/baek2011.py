import sys
input = sys.stdin.readline
a = list(input().strip())
print(a)
# len_a = len(a)
# dp = [0 for i in range(len_a +1)]
# dp[0], dp[1] = 1, 1
# if a[0] == "0":
#     print(0)
# else:
#     for i in range(2, len_a +1):
#         if int(a[i-1]) > 0:
#             dp[i] += dp[i-1]
#         num = int(a[i-1]) + int(a[i-2]) * 10
#         if num >= 10 and num <= 26:
#             dp[i] += dp[i-2]
#     print(dp[len_a] % 1000000)