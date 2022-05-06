T = int(input())

for loop in range(T):
    _map = [[0]*10 for _ in range(10)]
    N = int(input())
    count = 0
    for i in range(N):
        info = list(map(int, input().split()))

        for j in range(info[0],info[2] + 1):
            for k in range(info[1], info[3] + 1):
                if _map[j][k] != 0:
                    count += 1
                else:
                    _map[j][k] = info[4]
    print("#%d %d"%(loop+1, count))


T = int(input())

for loop in range(T):
    _map = [[0]*10 for _ in range(10)]
    N = int(input())
    count = 0
    for i in range(N):
        x1, y1, x2, y2, color = map(int, input.split())

        for j in range(x1,x2 + 1):
            for k in range(y1, y2 + 1):
                if _map[j][k] != 0:
                    count += 1
                else:
                    _map[j][k] = color
    print("#%d %d"%(loop+1, count))


