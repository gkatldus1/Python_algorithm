T = int(input())
for i in range(T):
    N = int(input())
    lst = list(map(int, input().split()))
    lst.sort()
    last = len(lst) - 1
    ans = []
    for k in range(5):
        ans.append(lst[last])
        ans.append(lst[k])
        last -= 1
    print("#{}".format(i+1), end=" ")
    for i in range(10):
        print(ans[i], end=" ")