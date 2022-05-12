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



