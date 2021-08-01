N, M = map(int, input().split())

def recur(data):
    if len(data) == M:
        print(*data)
        return
    for i in range(1, N+1):
        if i not in data:
            data.append(i)
            recur(data)
            data.pop()

recur([])
