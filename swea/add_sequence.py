

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    arr = list(map(int, input().split()))

    for i in range(M-1):
        _lst = list(map(int, input().split()))
        for i in range(len(arr)):
            if _lst[0] < arr[i]:
                arr[i:i] = _lst
                break
        else:
            arr = arr + _lst
    print(f"#{tc}", end=" ")
    print(*arr[::-1][0:10])






# for test in range(1,int(input())+1):
#     N, M = map(int, input().split())
#     arr = [float('inf')]
#     cnt = 0
#     for _ in range(M):
#         a = list(map(int, input().split()))
#         for i in range(N*cnt+1):
#             if a[0] < arr[i]:
#                 arr[i:i] = a
#                 break
#         cnt +=  1
#     print(f'#{test}',end=' ')
#     print(*arr[-11:-1][::-1])
