import sys
input = sys.stdin.readline

N, M = map(int, input().split())
data = [input().rstrip() for i in range(N)]

def check(graph):
    answer1, answer2 = 0, 0
    for i in range(8):
        for j in range(8):
            if (i + j) % 2 == 0:
                if graph[i][j] == 'B': answer1 += 1
                else: answer2 += 1
            else:
                if graph[i][j] == 'B': answer2 +=1
                else: answer1 +=1
    return min(answer1, answer2)

answer = int(1e9)

for i in range(N-7):
    for j in range(M-7):
        graph = [data[x][j:j+8] for x in range(i, i+8)]
        answer = min(answer, check(graph))

print(answer)

