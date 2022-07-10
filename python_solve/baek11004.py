import heapq
import sys
input = sys.stdin.readline

num = 0
n, k = map(int, input().split())

heap = list(map(int, input().split()))

heapq.heapify(heap)



for i in range(len(heap)):
    num = heapq.heappop(heap)
    print(num)



