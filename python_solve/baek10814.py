import sys
n = int(sys.stdin.readline())
member = []
for i in range(n):
    member.append(list(sys.stdin.readline().split()))
print(member)
member.sort(key=lambda x: int(x[0]))
print(member)
for i in range(n):
    print(member[i][0], member[i][1])