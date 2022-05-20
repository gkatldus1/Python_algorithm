

T = int(input())

for tc in range(1, T+1):
    N, M, L = map(int, input().split())
    lst = list(map(int, input().split()))

    for i in range(M):
        a, b = map(int, input().split())
        lst.insert(a, b)
    print("#{} {}".format(tc, lst[L]))