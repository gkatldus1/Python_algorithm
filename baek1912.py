import sys
input = sys.stdin.readline
n = int(input())
_list = list(map(int,input().split()))
dp = [_list[0]]
for i in range(n-1):
    dp.append(max(dp[i]+_list[i+1], _list[i+1]))
print(dp)
print(max(dp))
        
