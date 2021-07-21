import sys

input = sys.stdin.readline

_dict1, _dict2 = {}, {}
N, M = map(int, input().split())

for i in range(N):
    name = input()
    _dict1[name] = i + 1
    _dict2[i+1] = name

for i in range(M):
    target = input()
    if target.isdigit():
        print(_dict2[int(target)])
    else:
        print(_dict1[target])