from collections import deque

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    pizzas = list(map(int, input().split()))
    fire = deque([])
    num = 0
    
    
    for num in range(N):
        fire.append([pizzas[num], num])

    while len(fire) != 1:
        fire[0][0] //= 2

        if fire[0][0] == 0:
            if num < M - 1:
                num += 1
                fire.popleft()
                fire.append([pizzas[num], num])
            else:
                fire.popleft()
        else:
            fire.append(fire.popleft())
    print(f"#{tc} {fire[0][1] + 1}")