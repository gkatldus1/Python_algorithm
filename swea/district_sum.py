import sys

input = sys.stdin.readline

T = int(input())
for i in range(T):
    N, M = map(int,input().split())
    result = []
    V = list(map(int, input().split()))
    for j in range(N - M + 1):
        temp = 0
        for k in range(M):
            temp += V[j+k]
        result.append(temp)
    print("#{} {}".format(i+1, max(result)-min(result)))


T = int(input())
for i in range(T):
    N, M = map(int,input().split())
    V = list(map(int, input().split()))
    temp = 0
    for j in range(M):
        temp += V[j]
    max = temp
    min = temp

    for j in range(1, N - M + 1):
        temp = 0
        for k in range(j, j + M):
            temp += V[k]
        if temp > max:
            max = temp
        elif temp < min:
            min = temp
    print("#%d %d"%(i+1, max-min))