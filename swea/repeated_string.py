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

