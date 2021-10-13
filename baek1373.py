# import sys
# input = sys.stdin.readline

# numbers = input().rstrip()[::-1]
# res = ""
# total = 0
# cnt = 0
# for num in numbers:
#     total += int(num) * (2**cnt)
#     cnt += 1

# while True:
#     if total == 0:
#         print(res[::-1])
#         break
#     mok = total // 8
#     res += str(total % 8)
#     total = mok
print(oct(int(input(), 2))[2:])
