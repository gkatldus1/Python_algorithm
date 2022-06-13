import sys
from collections import deque

def solution ():
    func = sys.stdin.readline().rstrip()
    _ = sys.stdin.readline().rstrip()
    arr = deque(sys.stdin.readline().rstrip().strip('[]').split(','))

    flag = 0
    for c in func:
        if c == 'D':
            if not arr:
                print("err")
                return
            if flag == 0:
                arr.popleft()
            else:
                arr.pop()
        else:
            flag = 1 - flag
            #flag = 0 -> 1
            #flag = 1 -> 0
    if flag == 0:
        print('['+ ','.join(arr) + ']')
    else:
        print('[' + ','.join(list(arr[::-1]))+ ']')


for i in range(int(input())):
    solution()