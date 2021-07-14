import sys

input=sys.stdin.readline

string = input().rstrip()
flag = False
temp = ""
ans = ""
print(string)
for one in string :
    if flag == False:
        if one == '<' :
            temp += one
            flag = True
        elif one == " ":
            temp += one
            ans += temp
            temp = ""
        else:
            temp = one + temp
    else :
        if one == '>' :
            temp += one
            ans += temp
            temp = ""
            flag = False
        else:
            temp += one

print(ans+temp)

