import sys
from collections import deque

input = sys.stdin.readline
queue = deque()

def push_back(a):
    queue.append(a)

def push_front(a):
    queue.appendleft(a)

def pop_front():
    if(not queue):
        return -1
    else:
        return queue.popleft()
def pop_back():
    if(not queue):
        return -1
    else:
        return queue.pop()

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


n = int(input())

for i in range(n):

    command = input().rstrip().split()

    a1 = command[0]

    if a1 == "push_back":
        push_back(command[1])
    elif a1 == "push_front":
        push_front(command[1])
    elif a1 == "pop_front":
        print(pop_front())
    elif a1 == "pop_back":
        print(pop_back())
    elif a1 == "size":
        print(size())
    elif a1 == "empty":
        print(empty())
    elif a1 == "front":
        print(front())
    elif a1 == "back":
        print(back())
