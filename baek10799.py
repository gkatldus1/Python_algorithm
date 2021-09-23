bar_razor = list(input())
answer = 0
stack = []
# print(bar_razor)

for i in range(len(bar_razor)):
    if bar_razor[i] == '(':
        stack.append('(')

    else:
        if bar_razor[i-1] == '(':
            stack.pop()
            answer += len(stack) # 쇠막대기 잘린 수만큼 더해주기
        else:
            stack.pop()
            answer += 1 #본래 쇠막대기 개수를 더해주기
print(answer)
