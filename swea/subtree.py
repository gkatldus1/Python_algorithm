
def preorder(node):
    global cnt
    if node == 0:
        return
    cnt += 1
    preorder(left[node])
    preorder(right[node])
    
T = int(input())
for tc in range(1, T+1):
    E, N = map(int, input().split())
    _lst = list(map(int, input().split()))
    left = [0 for _ in range(E+2)]
    right = [0 for _ in range(E+2)]
    for i in range(0, len(_lst), 2):
        parent, child = _lst[i], _lst[i + 1]
        if left[parent]:
            right[parent] = child
        else:
            left[parent] = child
    cnt = 0
    preorder(N)
    print("#{} {}".format(tc, cnt))