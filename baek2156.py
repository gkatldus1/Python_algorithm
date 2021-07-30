import sys
input = sys.stdin.readline
w = [0] * 10001
n = int(input())
for i in range(n):
    w[i+1] = int(input())
dp = [0] * 10001
dp[1] = w[1]
if n > 1:
    dp[2] = w[1] + w[2]
for i in range(3, n+1):
    dp[i] = (max(dp[i-1], dp[i-2]+w[i], dp[i-3]+w[i-1]+w[i]))
print(dp[n])