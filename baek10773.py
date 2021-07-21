import sys

input = sys.stdin.readline

N = int(input())

_list = []
for i in range(N):
    tmp = int(input())
    if tmp == 0:
        _list.pop()
    else:
        _list.append(tmp)

print(sum(_list))