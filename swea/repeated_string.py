T = int(input())

for i in range(T):
    letters = input()
    stack = []
    for letter in letters:
        if stack and stack[-1] == letter:
            stack.pop()
        else:
            stack.append(letter)

    print("#{} {}".format(i+1, len(stack)))

TC = int(input())

for tc in range(1, TC+1):
    letters = input()
    stack = []
    for letter in letters:
        if not stack or stack[-1] != letter:
            stack.append(letter)  
        elif stack and stack[-1] == letter:
            stack.pop()
    print(f'#{tc} {len(stack)}')