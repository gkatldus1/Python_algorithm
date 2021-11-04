import sys
input = sys.stdin.readline

N = int(input())
factorial = 1
count = 0
for i in range(2, N+1):
    factorial *= i

for i in str(factorial)[::-1]:
    if i != '0':
        print(count)
        break
    else:
        count += 1