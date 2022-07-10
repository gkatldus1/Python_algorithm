import sys
input = sys.stdin.readline

l_stack = list(input().rstrip())
n = int(input())
r_stack = []

for i in range(n):
    comm = input().rstrip()
    if comm[0] == 'P':
        l_stack.append(comm[2])
    elif comm[0] == 'L' and l_stack:
        r_stack.append(l_stack.pop())
    elif comm[0] == 'D' and r_stack:
        l_stack.append(r_stack.pop())
    elif comm[0] == 'B' and l_stack:
        l_stack.pop()
print("".join(l_stack+list(reversed(r_stack))))


