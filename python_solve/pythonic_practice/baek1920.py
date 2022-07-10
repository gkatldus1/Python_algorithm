import sys
input = sys.stdin.readline

# a, b = map(int, sys.std.readlines())


N = int(input())

_set = set(map(int, input().split()))
M = int(input())

print(*[1 if dt in _set else 0 for dt in map(int, input().split())], sep='\n')

