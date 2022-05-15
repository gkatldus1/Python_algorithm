from collections import deque

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    dq = deque(list(input().split()))
    for i in range(M):
        dq.append(dq.popleft())
    print(f"#{tc} {dq[0]}")
    
