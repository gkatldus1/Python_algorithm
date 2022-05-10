T = int(input())
_dic = {
        ')': '(',
        '}':'{',
}
for i in range(T):
    stack = []
    strs = input()
    ans = 0
    for letter in strs:
        if letter == '(' or letter == '{':
            stack.append(letter)
        elif letter == ')' or letter == '}':
            if stack:
                if _dic[letter] == stack[-1]:
                    ans = 1
                    stack.pop()
                else:
                    ans= 0
                    break
            else:
                ans = 0
                break
    if stack:
        ans = 0
    print("#{} {}".format(i+1, ans))
