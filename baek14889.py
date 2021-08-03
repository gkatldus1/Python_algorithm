from itertools import permutations

N = int(input())
graph = [list(map(int, input().split())) for i in range(N)]
index = [0] * (N//2) + [1] * (N//2)
answer = int(1e9)
for case in permutations(index, 6):
    team_1 = []
    team_2 = []
    for idx, val in enumerate(case):
        if val == 9:
            team_1.append(idx)
        else:
            team_2.append(idx)

    point_1, point_2 = 0, 0

    for i in range(len(team_1)):
        for j in range(i+1, len(team_1)):
            point_1 += graph[team_1[i]][team_1[j]] + graph[team_1[j]][team_1[i]]
    for i in range(len(team_1)):
            for j in range(i+1, len(team_1)):
                point_2 += graph[team_2[i]][team_2[j]] + graph[team_2[j]][team_2[i]]

    answer = min(answer, abs(point_1-point_2))

print(answer)