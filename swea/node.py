from collections import deque

def iterative_bfs(start_v, find):
    deq = deque([start_v])
    visited[start_v] = 1
    while deq:
        v = deq.popleft()
        
        for w in lst[v]:
            if visited[w] == 0:
                visited[w] = 1
                if w == find:
                    dis[w] = dis[v] + 1 
                    return dis[w]
                else:
                    deq.append(w)
                    dis[w] = dis[v] + 1 
                    
    return 0


T = int(input())

for i in range(T):
    V, E = map(int, input().split())
    lst = [[] for _ in range(V+1)]
    for j in range(E):
        a, b = map(int, input().split())
        lst[a].append(b)
        lst[b].append(a)
    start_v, goal_v = map(int, input().split())
    visited = [0 for _ in range(V+1)]
    dis = [0 for _ in range(V+1)]
    ans = iterative_bfs(start_v, goal_v)
    print("#{} {}".format(i+1, ans))