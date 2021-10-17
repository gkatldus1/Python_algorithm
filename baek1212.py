import sys
# print(bin(int(input(), 8))[2:])
input = sys.stdin.readline

numbers = input().rstrip()[::-1]
res = ""
total = 0
cnt = 0
for num in numbers:
    total += int(num) * (8**cnt)
    cnt += 1

while True:
    if total == 0:
        print(res[::-1])
        break
    mok = total // 2
    res += str(total % 2)
    total = mok
