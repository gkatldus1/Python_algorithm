
T = int(input())

for tc in range(1, T + 1):
    N, K = map(int, input().split())
    map = []
    for _ in range(N):
        map.append(list(map(int, input().split())))
    total = 0
    
    # 행우선
    for col in range(N):
        count = 0
        for row in range(N):
            if map[col][row] == 0:
                if count == K:
                    total += 1
                count = 0
            else:
                count += 1
        if count == K:
            total += 1
            
    # 열우선
    for row in range(N):
        count = 0
        for col in range(N):
            if map[col][row] == 0:
                if count == K:
                    total += 1
                count = 0
            else:
                count += 1
        if count == K:
            total += 1

    print("#{} {}".format(tc, total))