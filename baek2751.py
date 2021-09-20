import sys
input = sys.stdin.readline
n = int(input())
_list = []
for i in range(n):
    _list.append(int(input()))
_list.sort()
for i in _list:
    print(i)