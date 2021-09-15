import sys
input = sys.stdin.readline
n = int(input())
_list = []
for i in range(n):
    _list.append(list(map(int, input().split())))
_list.sort(key=lambda x: (x[1], x[0]))
for i in _list:
    print(i[0], i[1])