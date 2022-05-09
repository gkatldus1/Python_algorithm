T = int(input())
for i in range(T):
    flag = 0
    N, M = map(int, input().split())
    _map = []
    for j in range(N):
        _map.append(input())

    for r in range(N):
        if flag == 1:
            break
        for c in range(N - M + 1):
            if _map[r][c:c + M] == _map[r][c: c+M][::-1]: 
                flag = 1
                print("#{} {}".format(i+1, _map[r][c:c+M]))
                break
    flag2 = 0
    if flag != 1:
        for r in range(N - M + 1):
            if flag2 == 1:
                break
            for c in range(N):
                c_list = []
                for k in range(M):
                    c_list.append(_map[r+k][c])
                if c_list == c_list[::-1]:
                    print("#{} {}".format(i+1, ''.join(c_list)))
                    flag2 = 1   
                    break
