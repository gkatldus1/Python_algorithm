# import sys
# input = sys.stdin.readline

# N = int(input())
# queue = []

# for i in range(N):
#     cmd = input().split()

#     if cmd[0] == "push":
#         queue.insert(0, cmd[1])
#     elif cmd[0] == "pop":
#         if len(queue) != 0: print(queue.pop())
#         else: print(-1)
#     elif cmd[0] == "size":
#         print(len(queue))
#     elif cmd[0] == "empty":
#         if len(queue) == 0: print(1)
#         else : print(0)
#     elif cmd[0] == "front":
#         if len(queue) == 0: print(-1)
#         else: print(queue[len(queue) -1])
#     elif cmd[0] == "back":
#         if len(queue) == 0: print(-1)
#         else: print(queue[0])

import sys
from collections import deque

input = sys.stdin.readline
queue = deque()

def push(a):
    queue.append(a)

def pop():
    if(not queue):
        return -1
    else:
        return queue.popleft()

def size():
    return len(queue)

def empty():
    if queue:
        return 0
    else:
        return 1

def front():
    return queue[0] if queue else -1

def back():
    return queue[-1] if queue else -1

# stack = []
n = int(input())

for i in range(n):

    command = sys.stdin.readline().rstrip().split()

    a1 = command[0]

    if a1 == "push":
        push(command[1])
    elif a1 == "pop":
        print(pop())
    elif a1 == "size":
        print(size())
    elif a1 == "empty":
        print(empty())
    elif a1 == "front":
        print(front())
    elif a1 == "back":
        print(back())

















