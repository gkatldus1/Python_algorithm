import sys
input = sys.stdin.readline

S = input().rstrip()

for i in range(len(S)):
    print(S[i:][::-1], ' ',S[i:] )
    if S[i:] == S[i:][::-1]:
        print(len(S)+i)
        print(S[i:][::-1], ' ',S[i:] )
        break
# s=input()

# for i in range(len(s)):
#     if s[i:]==s[i:][::-1]:
#         print(len(s)+i)
#         break