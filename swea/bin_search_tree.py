T = int(input())

def in_order(i):
    global cnt
    if i <= N:
        in_order(2*i)
        tree[i] = cnt
        cnt += 1
        in_order(2*i+1)

for tc in range(1, T+1):
    N = int(input())
    tree = [0 for _ in range(N+1)]

    cnt = 1
    in_order(1)
    print("#{} {} {}".format(tc, tree[1], tree[N//2]))





# def inorder(node_idx):
#     global number
#     if 1 <= node_idx <= N:
#         left_idx = node_idx *2 
#         if 1 <= left_idx <= N:
#             inorder(left_idx)
#         tree[node_idx] = number
#         number += 1

#         right_idx = (node_idx * 2) + 1
#         if 1 <= right_idx <= N:
#             inorder(right_idx)
        
        


# T = int(input())
# for tc in range(1, T+1):
#     N = int(input())

#     tree = [0] * (N+1)
#     number = 1
#     inorder(1)
#     print(f"#{tc}", tree[1], tree[N//2])