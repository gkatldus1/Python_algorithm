T = int(input())

for i in range(T):
    N = int(input()) // 10
    dp = [0]*(N+1)
    dp[1] = 1
    dp[2] = 3
    for k in range(3, N+1):
        dp[k] = dp[k-1] + dp[k-2] * 2
    print("#{} {}".format(i+1, dp[N]))