import sys

N, M = map(int, sys.stdin.readline().split())

X, Y = (N, M) if N > M else (M, N)

while X % Y:
    X, Y = Y, X % Y

sys.stdout.write("".join(['1']*Y))
