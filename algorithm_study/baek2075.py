import heapq
import sys
'''
최소힙으로 개수를 N개 유지한다면 마지막까지 루트가 
되는 숫자가 N번째 큰 수일 거라 생각하고 구현해봄
'''

N = int(input())

arr = []

for _ in range(N) :
    nums = list(map(int, sys.stdin.readline().split()))

    if len(arr) == 0 :
        for num in nums :
            heapq.heappush(arr, num)
        
    else :
        for num in nums :
            if arr[0] < num :
                heapq.heappop(arr)
                heapq.heappush(arr, num)
print(arr[0])



