from collections import deque

def is_safe(y,x):
    return 0 <= y < N and 0 <= x < N and(Maze[y][x] == 0 or Maze[y][x] == 3)

def BFS(start_y, start_x):
    global D_result
    Q.append((start_y, start_x))
    visited.append((start_y, start_x))

    while Q:
        start_y, start_x = Q.popleft()
        for dir in range(4):
            NewY = start_y + dy[dir]
            NewX = start_x + dx[dir]
            if is_safe(NewY, NewX) and (NewY, NewX) not in visited:
                Q.append((NewY,NewX))
                visited.append((NewY,NewX))
                Distance[NewY][NewX] = Distance[start_y][start_x] + 1
                if Maze[NewY][NewX] == 3:
                    return Distance[NewY][NewX] - 1
    return 0

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    Maze = [list(map(int, input())) for _ in range(N)]
    visited = [[]*N for _ in range(N)]

    for y in range(N):
        for x in range(N):
            if Maze[y][x] == 2:
                start_y, start_x = y, x

    dy = [1,-1,0,0]
    dx = [0,0,1,-1]

    Q = deque([])
    Distance = [[0]*N for _ in range(N)]
    ans = BFS(start_y, start_x)
    print(f'#{tc} {ans}')













# def is_safe(y,x):
#     return 0<=y<N and 0<=x<N 



# def iterative_bfs(start_v):
#     global result
#     sub_result = 0
#     deq = deque([start_v])
#     while deq:
#         y, x = deq.popleft()
#         visited[y][x] = 1
        
#         for dir in range(4):
#             new_y = y + dy[dir]
#             new_x = x + dx[dir]
#             if is_safe(new_y, new_x):
#                 if maze[new_y][new_x] == 0:
#                     deq.append((new_y,new_x))
#                     sub_result += 1
#                 elif maze[new_y][new_x] == 3:
#                     result = sub_result+1
#                     return result
            
            
#     return 0

# dy = [-1, 1, 0, 0]
# dx = [0, 0, -1, 1]


# T = int(input())
# for tc in range(1, T+1):
#     N = int(input())
#     maze = [list(map(int, input())) for i in range(N)]
#     # Maze = [list(map(int, input())) for _ in range(N)]
#     # maze = [list(map(int, list(input()))) for i in range(N)]
#     sub_result, result = 0, math.inf
#     visited = [[0]*N for i in range(N)]
    
#     for i in range(N):
#         for j in range(N):
#             if maze[i][j] == 2:
#                 start = (i, j)
#     ans = iterative_bfs(start)
#     print("#{} {}".format(tc, ans))