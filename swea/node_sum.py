T = int(input())

for tc in range(1, T+1):
    N, M, L = map(int, input().split())
    tree = [0 for _ in range(N+1)]
    for i in range(M):
        node, val = map(int, input().split())
        tree[node] = val
    for i in range(N, 0, -1):
        if (i//2) > 0:
            tree[i//2] += tree[i]
    print("#{} {}".format(tc, tree[L]))





# T = int(input())
# def post_order(i):
#     global _sum
#     if i > N:
#         return
#     if tree[i] > 0:
#         _sum += tree[i]
#         return
    
#     post_order(2*i)
#     post_order(2*i+1)
#     tree[i] = _sum

# for tc in range(1, T+1):
#     N, M, L = map(int, input().split())
#     tree = [0 for _ in range(N+1)]
#     for i in range(M):
#         node, val = map(int, input().split())
#         tree[node] = val
#     _sum = 0
#     post_order(1)
#     print("#{} {}".format(tc, tree[L]))