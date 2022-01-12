import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

def dfs(start_v, checked):
    checked.append(start_v)
    # print(start_v, end=' ')

    for w in range(len(graph[start_v])):
        if graph[start_v][w] == 1 and(w not in checked):
            dfs(w, checked)

N, M = map(int, input().split())

graph = [[0] * (N+1) for _ in range(N+1)]
checked = []
cnt = 0
for _ in range(M):
    u, v = map(int, input().split())
    graph[u][v] = graph[v][u] = 1

for point in range(1, N+1):
    if point not in checked:
        dfs(point, checked)
        cnt += 1
print(cnt)
