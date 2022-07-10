import sys
input = sys.stdin.readline

limit_number = 15000
sys.setrecursionlimit(limit_number)

global remain 

nums = []

def dfs(A:str, P: int) -> int:
    global remain
    temp = 0
    for i in A:
        temp += int(i) ** int(P)
        # print(temp)
    if temp in nums:
        remain = nums.index(temp)
        
        # print(remain, temp, "pri")
        return 
    else:
        nums.append(temp)
        dfs(str(temp), int(P))


A, P = input().split()
ans = dfs(A, int(P))
print(remain)

A, P = map(int, input().split())

nums = [A]
while True:
    tmp = 0
    for s in str(nums[-1]):
        tmp += int(s) ** P
    if tmp in nums:
        break
    
    nums.append(tmp)
print(nums.index(tmp))