from collections import deque
deq = deque()
result = ""
temp=[]
n, k = [int(x) for x in input().split()]
print(n, k)

for i in range(1, n+1) :
    deq.append(i)




while len(deq) != 0 :
    deq.rotate(-(k-1))
    temp.append(str(deq.popleft()))

print("<", ', '.join(str(i) for i in temp), ">", sep = '')






