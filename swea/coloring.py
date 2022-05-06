T = int(input())

for loop in range(T):
    map = [[0 for i in range(10)] for i in range(10)]
    N = int(input())
    count = 0
    for i in range(N):
        info = list(map(int, input().split()))
        V = list(map(int, input().split()))

        for j in range(info[0],info[2] + 1):
            for k in range(info[1], info[3] + 1):
                if map[j][k] != 0:
                    count += 1
                else:
                    map[j][k] = info[4]
        print("#%d %d"%(i+1, count))


