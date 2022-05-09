import itertools

T = int(input())
for i in range(T):
    All = [1,2,3,4,5,6,7,8,9,10,11,12]
    N, K = map(int, input().split())
    count = 0
    for j in itertools.combinations(All, N):
        if sum(j) == K:
            count += 1
    print("#{} {}".format(i+1, count))
