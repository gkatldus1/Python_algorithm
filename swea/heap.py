def heap_sort(node):
    pt_node = node // 2
    if pt_node <= 0:
        return
    else:
        if tree[pt_node] > tree[node]:
            tree[node], tree[pt_node] = tree[pt_node], tree[node]
            heap_sort(pt_node)

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    tree = [0]
    node_num = 1
    for num in map(int, input().split()):
        tree.append(num)
        heap_sort(node_num)
        node_num += 1
    sum_value = 0
    while N:
        N //= 2
        sum_value += tree[N]
    print("#{} {}".format(tc, sum_value))








import heapq
from collections import deque
T = int(input())

for tc in range(1, T+1):
    N = int(input())
    _list = deque(list(map(int, input().split())))
    heapq.heapify(_list)
    heap = [0]
    for i in range(len(_list)):
        heap.append(_list.popleft())

    idx = len(heap) - 1
    ans = 0
    while idx >= 1:
        idx //= 2
        ans += heap[idx]
    print("#{} {}".format(tc, ans))