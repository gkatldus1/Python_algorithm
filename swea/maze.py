T = int(input())
move = [(1,0),(0,1),(-1,0),(0,-1)]

def iterative_dfs(start_v):
    stack = [start_v]
    while stack:
        x, y = stack.pop()
        discovered[x][y] = 1
        for x1, y1 in move:
            move_x, move_y = x+x1, y+y1
            if -1< move_x < N and -1< move_y < N:
                if maze[move_x][move_y] == 3:
                    return 1
                elif maze[move_x][move_y] == 0 and discovered[move_x][move_y] == 0:   
                    stack.append((move_x, move_y))
    return 0
                

for tc in range(1, T+1):
    start = None
    N = int(input())
    maze = []
    for i in range(N):
        _input = list(map(int, list(input())))
        
        for j in range(N):
            if _input[j] == 2:
                start = (i, j)
        maze.append(_input)
    discovered = [[0]*N for _ in range(N)]
    ans = iterative_dfs(start)

    print("#{} {}".format(tc, ans))


def IsSafe(y,x):
    return 0<=y<N and 0<=x<N and (Maze[y][x] == 0 or Maze[y][x] == 3)

def DFS(start_y, start_x):
    global result

    if Maze[start_y][start_x] == 3:
        result = 1
        return

    visited.append((start_y, start_x))
    for dir in range(4):
        New_Y = start_y + dy[dir]
        New_X = start_x + dx[dir]
        if IsSafe(New_Y, New_X) and (New_Y, New_X) not in visited:
            DFS(New_Y, New_X)


TC = int(input())
for tc in range(1, TC+1):
    N = int(input())
    Maze = [list(map(int, input())) for _ in range(N)]

    for y in range(N):
        for x in range(N):
            if Maze[y][x] == 2:
                start_y, start_x = y,x

    #상, 하, 좌, 우
    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]

    visited = []
    result = 0
    DFS(start_y, start_x)
    print('#%d %d'%(tc, result))
