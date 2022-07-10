import sys
input = sys.stdin.readline

A, B = input().split()
m = int(input())
nums = list(map(int, input().split()))
ten = 0
answer = []
for _ in range(m):
    ten += nums[-1] * (int(A) ** _ )
    nums.pop(-1)
while ten != 0:
    answer.append(str(ten % int(B)))
    ten = ten // int(B)
print(' '.join(answer[::-1]))