import sys
input = sys.stdin.readline

N = int(input())
ans = 1

while N != 1:
    if N == 0:
        print(1)
        sys.exit()
    ans *= N
    N -= 1

print(ans)
