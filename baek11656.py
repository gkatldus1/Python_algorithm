import sys
suffix = []
s = sys.stdin.readline().rstrip()


for i in range(len(s)):
    suffix.append(s[i:])
suffix.sort()
for i in range(len(suffix)):
    print(suffix[i])

