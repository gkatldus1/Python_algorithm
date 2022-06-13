import collections

def climbStairs(self, n: int) -> int:
    if n == 1:
        return 1
    elif n == 2:
        return 2
    return climbStairs(n-2) + climbStairs(n-1)

class Solution:
    dp = collections.defaultdict(int)
    dp[1] = 1
    dp[2] = 2
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return self.dp[1]
        elif n == 2:
            return self.dp[2]
        elif self.dp[n]:
            return self.dp[n]
        
        self.dp[n] = self.climbStairs(n-2) + self.climbStairs(n-1)
        
        return self.dp[n]
