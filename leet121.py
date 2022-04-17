from cmath import inf
from typing import List

def maxProfit(self, prices: List[int]) -> int:
    results = 0
    for i, price in enumerate(prices):
        for j in range(i + 1, len(prices)):
            results = max(prices[j] - price, results)
    
    return results

def maxProfit(self, prices: List[int]) -> int:
    low = inf
    result = 0
    for price in prices:
        result = max(result, price - low)
        low = min(price, low)

    return result