N, M = map(int, input().split())

def recur(data, last):
    if len(data) == M:
        print(*data)
        return
    for i in range(last + 1, N +1):
        if i not in data:
            data.append(i)
            recur(data, i)
            data.pop()

recur([], 0)