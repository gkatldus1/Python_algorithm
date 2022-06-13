import sys
input = sys.stdin.readline
n = int(input())
_list = list(map(int, input().split()))
dp = [1 for i in range(n)]
for i in range(1, n):
    s = []
    for j in range(i):
        if _list[i] < _list[j]:
            s.append(dp[j])
    if not s:
        continue
    else:
        dp[i] += max(s)
print(max(dp))