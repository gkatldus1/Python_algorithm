# n = int(input())

# for i in range(n):
    
#     s = list(input())
    
#     sum = 0
#     for i in  s:
#         if i == '(':
#             sum += 1
#         elif i == ')':
#             sum -= 1
#         if sum < 0:
#             print('NO')
#             break
#     if sum > 0:
#         print('NO')
#     elif sum == 0:
#         print('YES')

num = int(input())

for i in range(num):
    flag = False
    input_data = input()
    brace = []

    for j in input_data:
        if j == "(":
            brace.append(j)
            flag = True
        elif j == ")":
            if len(brace) != 0:
                brace.pop()
            else:
                print("NO")
                flag = False
                break

    if flag :
        if len(brace) == 0:
            print("YES")
        else:
            print("NO")