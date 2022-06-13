import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    
    answer = 0
    
    while len(scoville) >= 2 and scoville[0] < K:
        answer += 1
        num1, num2 = heapq.heappop(scoville), heapq.heappop(scoville)
        heapq.heappush(scoville, num1 + num2*2)
        
    
    return answer if scoville[0] >= K else -1