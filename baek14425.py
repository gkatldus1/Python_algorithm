import sys

input = sys.stdin.readline

N, M = map(int, input().split())
# _set = set()
_set = {input() for i in range(N)}
answer = 0
for i in range(M):
    if input() in _set:
        answer += 1

print(answer)
