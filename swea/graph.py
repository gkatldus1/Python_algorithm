from collections import deque

def iterative_bfs(start_v, lst, find):
    deq = deque([start_v])
    while deq:
        v = deq.popleft()
        for w in lst[v]:
            if w == find:
                return 1
            deq.append(w)
    return 0

T = int(input())

for i in range(T):
    V, E = map(int, input().split())
    lst = [[] for _ in range(V+1)]
    for j in range(E):
        a, b = map(int, input().split())
        lst[a].append(b)
    start_v, goal_v = map(int, input().split())
    ans = iterative_bfs(start_v, lst, goal_v)
    print("#{} {}".format(i+1, ans))
