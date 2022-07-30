def degree_90(ar, n):
    temp = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            temp[j][n - i - 1] = ar[i][j]

    return temp

T = int(input())
for tc in range(1, T + 1):
    print('#{}'.format(tc))
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
    # [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

    a = []
    a.append(degree_90(arr, N))
    for x in range(N - 1):
        print(a)
        a.append(degree_90(a[x], N))

    for i in range(N):
        for j in range(N * 3):
            print(a[j // N][i][j % N], end='')
            if (j + 1) % N == 0:
                print(end=' ')
        print()