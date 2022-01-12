# import sys
# from collections import deque
# input = sys.stdin.readline

# def bfs(start_v):
#     queue = deque()
#     queue.append(start_v)
#     check[start_v] = 1
#     while queue:
#         v = queue.popleft()
#         for w in range(1,len(graph[v])):
#             if graph[v][w] == 1:
#                 if check[w] == 0 :
#                     queue.append(graph[v][w])
#                     check[w] = -check[v]
#                 else:
#                     if check[w] == check[v]:
#                         return False
#     return True
                
                
            


# K = int(input())
# for _ in range(K):
#     V, E = map(int, input().split())
#     graph = [[0]*(V+1) for k in range(V+1)]
#     check = [0]*(V+1)
#     for i in range(E):
#         u, v = map(int, input().split())
#         graph[u][v] = graph[v][u] = 1
#     ans = bfs(1)
#     print("YES" if ans else "NO")

from collections import deque
import sys
input = sys.stdin.readline
k = int(input())
def bfs(start):
    bi[start] = 1
    q = deque()
    q.append(start)
    while q:
        a = q.popleft()
        for i in s[a]:
            if bi[i] == 0:
                bi[i] = -bi[a]
                q.append(i)
            else:
                if bi[i] == bi[a]:
                    return False
    return True
for i in range(k):
    v, e = map(int, input().split())
    isTrue = True
    s = [[] for i in range(v+1)]
    bi = [0 for i in range(v+1)]
    for j in range(e):
        a, b = map(int, input().split())
        s[a].append(b)
        s[b].append(a)
    for k in range(1, v+1):
        if bi[k] == 0:
            if not bfs(k):
                isTrue = False
                break
    print("YES" if isTrue else "NO")



