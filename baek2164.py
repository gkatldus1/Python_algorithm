from collections import deque

dq = deque(range(1, int(input())+1))

while len(dq) != 1:
    dq.popleft() #위쪽에 있는 카드 삭제
    #위쪽에 있는 카드를 삭제해서 아래로 보낸다.
    dq.append(dq.popleft())

print(dq[0])