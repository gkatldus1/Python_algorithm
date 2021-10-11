import sys
input = sys.stdin.readline

N, B = input().split()
B = int(B)
cnt, result = 0, 0
for char in N[::-1]:
    number = int(char) if char.isdigit() else ord(char) - 55
    result += (number * (B**cnt))
    cnt += 1
print(result)
