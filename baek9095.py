import sys
input = sys.stdin.readline
T = int(input())
_list = [0, 1, 2, 4] + 8*[0]

def recur(n):
    if n <= 3 or _list[n] != 0:
        return _list[n]
    else:
        _list[n] = recur(n-1) + recur(n-2) + recur(n-3)
        return _list[n]




for i in range(T) :
    n = int(input())
    ans = recur(n)
    print(ans)
