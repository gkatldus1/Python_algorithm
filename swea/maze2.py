from collections import deque

def is_safe(y,x):
    return 0<=y<N and 0<=x<N 

def iterative_bfs(start_v, lst, find):
    deq = deque([start_v])
    while deq:
        y, x = deq.popleft()
        visited[y][x] = 1
        for dir in range(4):
            new_y = y + dy[dir]
            new_x = x + dx[dir]
            if is_safe(new_y, new_x):
                if maze[new_y][new_x] == 0:
                    deq.append((new_y,new_x))
                elif maze[new_y][new_x] == 3:
                    
                return 1
            deq.append(w)
    return 0

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]


T = int(input())
for tc in range(1, T+1):
    N = int(input())
    maze = [list(map(int, input().split())) for i in range(N)]
    visited = [[0]*N for i in range(N)]
    for i in range(N):
        for j in range(N):
            if maze[i][j] == 2:
                start = (i, j)
    