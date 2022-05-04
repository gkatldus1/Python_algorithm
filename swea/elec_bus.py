import sys
input = sys.stdin.readline

T = int(input())
for j in range(T):
    K, N, M = list(map(int, input().split()))
    charger = list(map(int, input().split()))

    current = count = 0

    while current + K < N:
        for i in range(K, 0, -1):
            if (current + i) in charger:
                current += i
                count += 1
                break
        else:
            count = 0
            break
    print("#{} {}".format(j+1, count))
