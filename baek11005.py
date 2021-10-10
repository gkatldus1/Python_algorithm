import sys

input = sys.stdin.readline

system = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
answer = ""
N, B = map(int, input().split())

while N != 0:
    answer += str(system[N % B])
    N = N // B

print(answer[::-1])
